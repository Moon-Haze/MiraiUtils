package edu.sdust.moon.Core;

import edu.sdust.moon.EventListener.EventListener;
import edu.sdust.moon.Utils.ConfigReadUtil;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactoryJvm;
import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.Events;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.SimpleListenerHost;
import net.mamoe.mirai.event.events.BotOfflineEvent;
import net.mamoe.mirai.network.LoginFailedException;
import net.mamoe.mirai.utils.BotConfiguration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;

/**
 * QQ 机器人启动
 *
 * 可以选择 JSON 配置文件 或者 选择程序内部使用函数输入配置信息 登录。
 *
 * @author Moon
 */
public class QQBot {

    private static final Logger logger = LogManager.getLogger(QQBot.class);
    private static final ArrayList<Bot> BOTS = new ArrayList<>();
    private static final QQBot QQ_BOT = new QQBot();
    private static String runDir;
    private static ConfigObj config;

    static {
        Events.registerEvents(new SimpleListenerHost() {

            /**
             * 被挤下线（事件）
             *
             * @param event
             * @return
             */
            @EventHandler
            public ListeningStatus BotForceOfflineEvent(BotOfflineEvent.Force event) {
                QQObj QQ = config.getQQ(event.getBot().getId());
                switch (QQ.getType()) {
                    case 0:
                        QQ.setType(1);
                        break;
                    case 1:
                        QQ.setType(2);
                        break;
                    case 2:
                    default:
                        QQ.setType(0);
                }
                return ListeningStatus.LISTENING;
            }
            /**
             * 被服务器断开（事件）
             *
             * @param event
             * @return
             */
            @EventHandler
            public ListeningStatus BotMsfOfflineEvent(BotOfflineEvent.MsfOffline event) {
                System.exit(0);
                return ListeningStatus.LISTENING;
            }

            /**
             * 因网络问题而掉线
             *
             * @param event
             * @return
             */
            @EventHandler
            public ListeningStatus BotDroppedOfflineEvent(BotOfflineEvent.Dropped event) {
                System.exit(0);
                return ListeningStatus.LISTENING;
            }


            @Override
            public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
                super.handleException(context, exception);
            }
        });
    }

    /**
     * 使用单例模式，使用此方法可获取唯一的 BotStart
     *
     * @return BotStart
     */
    public static QQBot getInstance() {
        return QQ_BOT;
    }


    /**
     * 登录 QQ
     *
     * @param path 配置信息的位置，如果 path = null 则选择默认配置位置。
     *
     * @return true Or false
     */
    public boolean logIn(String path) {
        if (path == null) {
            runDir = System.getProperty("user.dir");
        } else {
            runDir = path;
        }
        logger.info("Starting...");
        config = ConfigReadUtil.readConfig(runDir);
        if (config == null) {
            logger.info("Please modify the configuration file and restart.");
            return false;
        }
        logger.info("Initialization complete.");
        try {
            for (QQObj QQObj : config.getQQs()) {
                _log_in_(QQObj);
            }
        } catch (LoginFailedException e) {
            return false;
        }
        return true;
    }

    /**
     * @param qq       QQ
     * @param password Password
     * @param protocol 登录的协议，手机 ( MiraiProtocol.ANDROID_PHONE ) 手表 ( MiraiProtocol.ANDROID_WATCH ) 平板 ( MiraiProtocol.ANDROID_PAD )
     * @return true Or false
     */
    public Bot logIn(long qq, String password, final BotConfiguration.MiraiProtocol protocol) {
        Bot bot = null;
        bot = BotFactoryJvm.newBot(qq, password, new BotConfiguration() {
            {
                fileBasedDeviceInfo(runDir + "/config/info.json");
                setProtocol(protocol);
            }
        });
        bot.login();
        bot.getConfiguration().redirectNetworkLogToDirectory(new File(runDir + "/log/BotNetWork"));
        bot.getConfiguration().redirectBotLogToDirectory(new File(runDir + "/log/BotLog"));
        logger.info("QQ:" + qq + "Is logged in");
        BOTS.add(bot);
        return bot;
    }

    /**
     * 监听是否有 QQ 下线，如果有，则重新登录。这个方法可以避免QQ下线。
     */
    public void reLogIn() {
        while (true) {
            for (Bot bot : BOTS) {
                if (!bot.isOnline()) {
                    bot.close(null);
                    BOTS.remove(bot);
                    _log_in_(config.getQQ(bot.getId()));
                }
            }
        }
    }


    /**
     * 注册事件
     *
     * @param listener EventListener的子孙类
     */
    public void registerEvents(EventListener listener) {
        Events.registerEvents(listener);
    }

    public static Logger getLogger() {
        return logger;
    }

    private Bot _log_in_(QQObj QQ){
        Bot bot = null;
        if (QQ != null) {
            switch (QQ.getType()) {
                case 1:
                    bot = logIn(QQ.getQQ(), QQ.getPassword(), BotConfiguration.MiraiProtocol.ANDROID_WATCH);
                    break;
                case 2:
                    bot = logIn(QQ.getQQ(), QQ.getPassword(), BotConfiguration.MiraiProtocol.ANDROID_PAD);
                    break;
                case 0:
                default:
                    bot = logIn(QQ.getQQ(), QQ.getPassword(), BotConfiguration.MiraiProtocol.ANDROID_PHONE);
                    break;
            }
        }
        return bot;
    }
}
package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.*;

/**
 * 机器人设置的事件监听器
 *
 * @author Moon
 */
public class BotSettingEventListener extends EventListener {
    /**
     * 登录完成, 好友列表, 群组列表初始化完成（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotOnlineEvent(BotOnlineEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 头像被修改（通过其他客户端修改了头像）（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotAvatarChangedEvent(BotAvatarChangedEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 昵称被改变事件, 在此事件触发时 bot 已经完成改名
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotNickChangedEvent(BotNickChangedEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 主动或被动重新登录（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotReloginEvent(BotReloginEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 主动离线（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotActiveOfflineEvent(BotOfflineEvent.Active event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 被挤下线（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotForceOfflineEvent(BotOfflineEvent.Force event) {
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
        return ListeningStatus.LISTENING;
    }

    /**
     * 因 returnCode = -10008 等原因掉线
     *
     * @param event
     * @return
     */
    public ListeningStatus PacketFactory10008(BotOfflineEvent.PacketFactory10008 event) {
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
        return ListeningStatus.LISTENING;
    }

    /**
     * 服务器主动要求更换另一个服务器（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotRequireReconnectOfflineEvent(BotOfflineEvent.RequireReconnect event) {
        return ListeningStatus.LISTENING;
    }
}
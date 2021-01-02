package edu.sdust.moon.Response;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.ContactList;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.message.action.BotNudge;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageSource;
import net.mamoe.mirai.message.data.OfflineMessageSource;
import net.mamoe.mirai.utils.BotConfiguration;
import net.mamoe.mirai.utils.Context;
import net.mamoe.mirai.utils.MiraiLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Future;

/**
 * BotResponse Bot的响应类
 * @author Moon
 */
public class BotResponse extends Response {
    Bot bot;

    public BotResponse(Bot bot){
        this.bot=bot;
    }

    public void join() {
        bot.join();
    }

    @Nullable
    public static Bot getInstanceOrNull(long qq) {
        return Bot.getInstanceOrNull(qq);
    }


    @NotNull
    public static Bot getInstance(long qq) throws NoSuchElementException {
        return Bot.getInstance(qq);
    }

    public void recall(@NotNull MessageSource source) {
        bot.recall(source);
    }

    @NotNull
    public Future<Unit> recallAsync(@NotNull MessageSource source) {
        return bot.recallAsync(source);
    }

    public void recallIn(@NotNull MessageSource source, long millis) {
        bot.recallIn(source, millis);
    }

    public void recall(@NotNull MessageChain message) {
        bot.recall(message);
    }

    @NotNull
    public String queryImageUrl(@NotNull Image image) {
        return bot.queryImageUrl(image);
    }

    @NotNull
    public static List<Bot> getBotInstances() {
        return Bot.getBotInstances();
    }

    public void recallIn(@NotNull MessageChain source, long millis) {
        bot.recallIn(source, millis);
    }

    @NotNull
    public BotConfiguration getConfiguration() {
        return bot.getConfiguration();
    }

    @NotNull
    public Context getContext() {
        return bot.getContext();
    }

    @NotNull
    public CoroutineContext getCoroutineContext() {
        return bot.getCoroutineContext();
    }

    @NotNull
    public ContactList<Friend> getFriends() {
        return bot.getFriends();
    }

    @NotNull
    public ContactList<Group> getGroups() {
        return bot.getGroups();
    }

    public long getId() {
        return bot.getId();
    }

    public boolean isOnline() {
        return bot.isOnline();
    }

    @NotNull
    public MiraiLogger getLogger() {
        return bot.getLogger();
    }

    @NotNull
    public String getNick() {
        return bot.getNick();
    }

    @NotNull
    public Friend getSelfQQ() {
        return bot.getSelfQQ();
    }

    public void close(@Nullable Throwable throwable) {
        bot.close(throwable);
    }

    @NotNull
    public OfflineMessageSource constructMessageSource(@NotNull OfflineMessageSource.Kind kind, long l, long l1, int i, int i1, int i2, @NotNull MessageChain messageChain) {
        return bot.constructMessageSource(kind, l, l1, i, i1, i2, messageChain);
    }

    @NotNull
    public FriendResponse getFriend(long id) {
        return new FriendResponse(bot.getFriend(id));
    }

    @NotNull
    public GroupResponse getGroup(long id) {
        return new GroupResponse(bot.getGroup(id));
    }

    @NotNull
    public BotNudge nudge() {
        return bot.nudge();
    }
}

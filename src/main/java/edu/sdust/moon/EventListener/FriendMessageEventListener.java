package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.FriendInputStatusChangedEvent;
import net.mamoe.mirai.event.events.FriendMessagePostSendEvent;
import net.mamoe.mirai.event.events.FriendMessagePreSendEvent;
import net.mamoe.mirai.message.FriendMessageEvent;


/**
 * Bot 的好友消息的事件监听类
 *
 * @author Moon
 */
public class FriendMessageEventListener extends EventListener {
    /**
     * [机器人]收到朋友消息（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus FriendMessageEvent(FriendMessageEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]好友输入状态改变（事件）
     *
     * @param event
     * @return
     */
    public ListeningStatus FriendInputStatusChangedEvent(FriendInputStatusChangedEvent event) {
        return ListeningStatus.LISTENING;
    }
    /**
     * [机器人]在好友消息发送后广播（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus FriendMessagePostSendEvent(FriendMessagePostSendEvent event) {
        return ListeningStatus.LISTENING;
    }
    /**
     * [机器人]在发送好友消息前广播（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus FriendMessagePreSendEvent(FriendMessagePreSendEvent event) {
        return ListeningStatus.LISTENING;
    }
}

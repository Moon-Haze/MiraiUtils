package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.GroupMessagePostSendEvent;
import net.mamoe.mirai.event.events.GroupMessagePreSendEvent;
import net.mamoe.mirai.message.GroupMessageEvent;


/**
 * Bot 群的消息的事件监听类
 *
 * @author Moon
 */
public class GroupMessageEventListener extends EventListener {
    /**
     * [机器人]收到群消息（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus GroupMessageEvent(GroupMessageEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]在群消息发送后广播（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus GroupMessagePostSendEvent(GroupMessagePostSendEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]在发送群消息前广播（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus GroupMessagePreSendEvent(GroupMessagePreSendEvent event) {
        return ListeningStatus.LISTENING;
    }



}

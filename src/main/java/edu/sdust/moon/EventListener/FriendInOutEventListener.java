package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.FriendAddEvent;
import net.mamoe.mirai.event.events.FriendDeleteEvent;
import net.mamoe.mirai.event.events.NewFriendRequestEvent;


/**
 * Bot 的好友添加或删除的事件监听类
 *
 * @author Moon
 */
public class FriendInOutEventListener extends EventListener {

    /**
     * [机器人]一个账号请求添加机器人为好友（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus NewFriendRequestEvent(NewFriendRequestEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]成功添加了一个新好友（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus FriendAddEvent(FriendAddEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]好友已被删除（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus FriendDeleteEvent(FriendDeleteEvent event) {
        return ListeningStatus.LISTENING;
    }
}

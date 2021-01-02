package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.FriendAvatarChangedEvent;
import net.mamoe.mirai.event.events.FriendNickChangedEvent;
import net.mamoe.mirai.event.events.FriendRemarkChangeEvent;


/**
 * Bot 的好友设置 的事件监听类
 *
 * @author Moon
 */
public class FriendSettingEventListener extends EventListener {


    /**
     * 昵称改变事件, 在此事件广播时好友已经完成改名
     * @param event
     * @return
     */

    public ListeningStatus FriendNickChangedEvent(FriendNickChangedEvent event){
        return ListeningStatus.LISTENING;
    }


    /**
     * 好友昵称改变事件. 目前仅支持解析 (来自 PC 端的修改).
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus FriendRemarkChangeEvent(FriendRemarkChangeEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 头像被修改. 在此事件广播前就已经修改完毕.
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus FriendAvatarChangedEvent(FriendAvatarChangedEvent event) {
        return ListeningStatus.LISTENING;
    }
}

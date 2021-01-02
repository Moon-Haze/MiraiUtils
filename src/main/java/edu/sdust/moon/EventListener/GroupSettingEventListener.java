package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.*;

/**
 * 群设置的事件监听类
 * @author Moon
 */
public class GroupSettingEventListener {

    /**
     * 群 "匿名聊天" 功能状态改变（事件）
     *
     * @param event
     */
    @EventHandler
    public ListeningStatus GroupAllowAnonymousChatEvent(GroupAllowAnonymousChatEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]群 "坦白说" 功能状态改变（事件）
     *
     * @param event
     */
    @EventHandler
    public ListeningStatus GroupAllowConfessTalkEvent(GroupAllowConfessTalkEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]群 "允许群员邀请好友加群" 功能状态改变（事件）
     *
     * @param event
     */
    @EventHandler
    public ListeningStatus GroupAllowMemberInviteEvent(GroupAllowMemberInviteEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]入群公告改变（事件）
     *
     * @param event
     */
    @EventHandler
    public ListeningStatus GroupEntranceAnnouncementChangeEvent(GroupEntranceAnnouncementChangeEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]群名改变（事件）
     *
     * @param event
     */
    @EventHandler
    public ListeningStatus GroupNameChangeEvent(GroupNameChangeEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]群 "全员禁言" 功能状态改变（事件）
     *
     * @param event
     */
    @EventHandler
    public ListeningStatus GroupMuteAllEvent(GroupMuteAllEvent event) {
        return ListeningStatus.LISTENING;
    }

}

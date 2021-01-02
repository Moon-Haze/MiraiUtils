package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.*;

/**
 * Bot 在群的事件监听类
 *
 * @author Moon
 */
public class BotGroupEventListener extends EventListener {

    /**
     * 被禁言（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotMuteEvent(BotMuteEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 被取消禁言（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotUnmuteEvent(BotUnmuteEvent event) {

        return ListeningStatus.LISTENING;
    }

    /**
     * 主动退出一个群（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotQuitGroupEvent(BotLeaveEvent.Active event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 被管理员或群主踢出群（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotKickGroupEvent(BotLeaveEvent.Kick event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 成功加入了一个新群（不确定. 可能是主动加入）（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotActiveJoinGroupEvent(BotJoinGroupEvent.Active event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 成功加入了一个新群（机器人被一个群内的成员直接邀请加入了群）（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotInviteJoinGroupEvent(BotJoinGroupEvent.Invite event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 被邀请加入一个群（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotInvitedJoinGroupRequestEvent(BotInvitedJoinGroupRequestEvent event) {

        return ListeningStatus.LISTENING;
    }


    /**
     * 原群主通过 https://huifu.qq.com/ 恢复原来群主身份并入群, Bot 是原群主
     *
     * @param event
     * @return
     */
    public ListeningStatus BotRetrieveJoinGroupEvent(BotJoinGroupEvent.Retrieve event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 在群里的权限被改变. 操作人一定是群主（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BotGroupPermissionChangeEvent(BotGroupPermissionChangeEvent event) {
        return ListeningStatus.LISTENING;
    }
}

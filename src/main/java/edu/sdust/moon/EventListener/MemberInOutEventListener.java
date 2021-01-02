package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.BotInvitedJoinGroupRequestEvent;
import net.mamoe.mirai.event.events.MemberJoinEvent;
import net.mamoe.mirai.event.events.MemberJoinRequestEvent;
import net.mamoe.mirai.event.events.MemberLeaveEvent;

/**
 * 群成员 进群 或 退群 的事件监听类
 * @author Moon
 */
public class MemberInOutEventListener extends EventListener {
    /**
     * 一个账号请求加入群事件, [Bot] 在此群中是管理员或群主.（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus MemberJoinRequestEvent(MemberJoinRequestEvent event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 成员被邀请加入群（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus MemberInviteJoinEvent(MemberJoinEvent.Invite event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 成员主动加入群（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus MemberActiveJoinEvent(MemberJoinEvent.Active event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 成员被踢出群（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus MemberKickEvent(MemberLeaveEvent.Kick event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 成员主动离开（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus MemberQuitEvent(MemberLeaveEvent.Quit event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * 原群主通过 https://huifu.qq.com/ 恢复原来群主身份并入群
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus MemberJoinRetrieveEvent(MemberJoinEvent.Retrieve event) {
        return ListeningStatus.LISTENING;
    }
    @EventHandler
    public ListeningStatus BotInvitedJoinGroupRequestEvent(BotInvitedJoinGroupRequestEvent event){
        return ListeningStatus.LISTENING;
    }
}

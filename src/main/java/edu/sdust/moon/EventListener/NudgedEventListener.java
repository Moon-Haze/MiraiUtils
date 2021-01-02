package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.BotNudgedEvent;
import net.mamoe.mirai.event.events.MemberNudgedEvent;

/**
 * Bot 被戳一戳的事件监听器
 * @author Moon
 */
public class NudgedEventListener extends EventListener {

    /**
     * Member 被 [戳]的事件.
     *
     * @param event
     * @return
     */
    public ListeningStatus MemberNudgedEvent(MemberNudgedEvent event) {
        return ListeningStatus.LISTENING;
    }
    /**
     * Bot 被[戳]的事件.
     *
     * @param event
     * @return
     */
    public ListeningStatus BotNudgedEvent(BotNudgedEvent event) {
        return ListeningStatus.LISTENING;
    }
}

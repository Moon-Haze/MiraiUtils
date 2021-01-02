package edu.sdust.moon.Response;

import edu.sdust.moon.Core.Message;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Friend;
import net.mamoe.mirai.event.events.EventCancelledException;
import net.mamoe.mirai.event.events.FriendEvent;
import net.mamoe.mirai.message.action.Nudge;
import net.mamoe.mirai.message.data.MessageUtils;
import net.mamoe.mirai.utils.OverFileSizeMaxException;

import java.io.File;
import java.io.IOException;
import java.net.URL;


/**
 * FriendResponse Friend的响应类
 * @author Moon
 */
public class FriendResponse extends Response {
    private Friend friend;
    private FriendEvent event;

    /**
     * @param event 继承自 FriendEvent
     */
    public FriendResponse(FriendEvent event) {
        this.event = event;
        this.friend = event.getFriend();
    }

    /**
     * @param friend net.mamoe.mirai.contact.Friend
     */
    public FriendResponse(Friend friend) {
        this.friend = friend;
    }

    /**
     * @return 头像的URL
     */
    public String getAvatarUrl() {
        return friend.getAvatarUrl();
    }

    /**
     * @return QQ
     */
    public long getId() {
        return friend.getId();
    }

    /**
     * @return 昵称
     */
    public String getNick() {
        return friend.getNick();
    }

    /**
     * @return Bot
     */
    public Bot getBot() {
        return friend.getBot();
    }

    /**
     * 给好友发送消息
     *
     * @param message 消息
     */
    public void sendMessage(String message) throws EventCancelledException {
        Message.createMessage(friend.sendMessage(MessageUtils.newChain(message)).getSource());
    }

    public void sendMessageReCall(String message) throws EventCancelledException {
        friend.sendMessage(MessageUtils.newChain(message)).recall();
    }

    /**
     * 给好友发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendImage(File image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(
                friend.sendMessage(
                        friend.uploadImage(image)
                ).getSource()
        );
    }

    /**
     * 给好友发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendImage(URL image) throws OverFileSizeMaxException, EventCancelledException, IOException {
        Message.createMessage(
                friend.sendMessage(
                        friend.uploadImage(image)
                ).getSource()
        );
    }
    /**
     * 发送 戳一戳
     */
    public boolean sendNudge() {
        return Nudge.Companion.sendNudge(friend, friend.nudge());
    }
}
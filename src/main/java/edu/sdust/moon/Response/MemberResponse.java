package edu.sdust.moon.Response;

import edu.sdust.moon.Core.Message;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.Group;
import net.mamoe.mirai.contact.Member;
import net.mamoe.mirai.contact.MemberPermission;
import net.mamoe.mirai.contact.PermissionDeniedException;
import net.mamoe.mirai.event.events.EventCancelledException;
import net.mamoe.mirai.event.events.GroupMemberEvent;
import net.mamoe.mirai.message.action.Nudge;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.OverFileSizeMaxException;

import java.io.File;
import java.io.InputStream;
import java.net.URL;



/**
 * MemberResponse Member的响应类
 * @author Moon
 */
public class MemberResponse extends Response {
    private Member member;
    private GroupMemberEvent event;

    /**
     * @param event 继承自GroupMemberEvent
     */
    public MemberResponse(GroupMemberEvent event) {
        this.event = event;
        member = event.getMember();
    }

    /**
     * @param member 群成员的实体
     */
    public MemberResponse(Member member) {
        this.member = member;
    }

    /**
     * 在群中At@某群成员
     *
     * @throws EventCancelledException 事件被取消
     */
    public void sendAt() throws EventCancelledException {
        Message.createMessage(member.getGroup().sendMessage(new At(member)).getSource());
    }

    /**
     * 在群中At@某群成员
     *
     * @throws EventCancelledException 事件被取消
     */
    public void sendPrivateAt() throws EventCancelledException {
        Message.createMessage(member.sendMessage(new At(member)).getSource());
    }

    /**
     * 给某个群成员私发送消息
     *
     * @param message 消息内容
     * @throws EventCancelledException 事件被取消
     */
    public void sendPrivateMessage(String message) throws EventCancelledException {
        Message.createMessage(member.sendMessage(MessageUtils.newChain(message)).getSource());
    }

    /**
     * 发送消息并立即撤回
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */
    public void sendPrivateMessageRecall(String message) throws EventCancelledException {
        member.sendMessage(MessageUtils.newChain(message)).recall();
    }

    /**
     * 发送群消息, 多少毫秒后撤回
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */
    public void sendPrivateMessageRecall(String message, long timeMillis) throws EventCancelledException {
        member.sendMessage(MessageUtils.newChain(message)).recallIn(timeMillis);
    }

    /**
     * 发送群消息并@某人
     * 此函数只有在 GroupMessageEvent 事件中有效
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */
    public void sendMessageWithAt(String message) throws EventCancelledException {
        Message.createMessage(
                member.getGroup().sendMessage(
                        MessageUtils.newChain(message).plus(
                                new At(member)
                        )
                ).getSource()
        );
    }

    /**
     * 发送群消息并回复某人
     * 此函数只有在 GroupMessageEvent 事件中有效
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */

    public void sendMessageWithRecall(String message, OnlineMessageSource source) throws EventCancelledException {
        Message.createMessage(
                member.getGroup().sendMessage(MessageUtils.newChain(
                        new QuoteReply(source)
                ).plus(message)).getSource()
        );
    }

//    /**
//     * 给成员私发送图片
//     *
//     * @param image 图片的码
//     */
//    public void sendPrivateImage(String image) throws OverFileSizeMaxException {
//        MessageSource source = member.sendMessage(member.uploadImage(new ByteArrayInputStream(decoder.decode(image)))).getSource();
//        Message.createMessage(source);
//    }
//
//    /**
//     * 给群成员私发送图片
//     *
//     * @param image 图片
//     * @throws OverFileSizeMaxException 图片文件过大时抛出
//     */
//    public void sendPrivateImage(ExternalImage image) throws OverFileSizeMaxException {
//        MessageSource source = member.sendMessage(member.uploadImage(image)).getSource();
//        Message.createMessage(source);
//    }
//

    /**
     * 给群成员私发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大时抛出
     */
    public void sendPrivateImage(File image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(member.sendMessage(member.uploadImage(image)).getSource());
    }

    /**
     * 给群成员私发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大时抛出
     */
    public void sendPrivateImage(URL image) throws OverFileSizeMaxException {
        Message.createMessage(member.sendMessage(member.uploadImage(image)).getSource());
    }

    /**
     * 给群成员私发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大时抛出
     */
    public void sendPrivateImage(InputStream image) throws OverFileSizeMaxException {
        Message.createMessage(member.sendMessage(member.uploadImage(image)).getSource());
    }

    /**
     * 给群成员私发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大时抛出
     */
    public void sendPrivateFlashImage(File image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(member.sendMessage(FlashImage.from(member.uploadImage(image))).getSource());
    }

    /**
     * 给群成员私发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大时抛出
     */
    public void sendPrivateFlashImage(URL image) throws OverFileSizeMaxException {
        Message.createMessage(member.sendMessage(FlashImage.from(member.uploadImage(image))).getSource());
    }

    /**
     * 给群成员私发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大时抛出
     */
    public void sendPrivateFlashImage(InputStream image) throws OverFileSizeMaxException {
        Message.createMessage(member.sendMessage(FlashImage.from(member.uploadImage(image))).getSource());
    }

//    /**
//     * 给群成员私发送图片
//     *
//     * @param image 图片
//     * @throws OverFileSizeMaxException 图片文件过大时抛出
//     */
//    public void sendPrivateImage(BufferedImage image) throws OverFileSizeMaxException {
//        MessageSource source = member.sendMessage(member.uploadImage(image)).getSource();
//        Message.createMessage(source);
//    }

    /**
     * 踢群成员
     *
     * @throws PermissionDeniedException 无权限修改时抛出
     */
    public void kick() throws PermissionDeniedException {
        member.kick();
    }

    /**
     * 禁言
     *
     * @param seconds 时间（s）
     * @throws PermissionDeniedException 无权限修改时抛出
     */
    public void mute(int seconds) throws PermissionDeniedException {
        member.mute(seconds);
    }

    /**
     * 解除禁言
     *
     * @throws PermissionDeniedException 无权限修改时抛出
     */
    public void unmute() throws PermissionDeniedException {
        member.unmute();
    }

    /**
     * 踢群成员
     *
     * @param message 原因
     * @throws PermissionDeniedException 无权限修改时抛
     */
    public void kick(String message) throws PermissionDeniedException {
        member.kick(message);
    }

    /**
     * 发送  戳一戳
     *
     * @throws UnsupportedOperationException 当未使用 [安卓协议] MiraiProtocol.ANDROID_PHONE 时抛出
     */
    public boolean sendNudge() throws UnsupportedOperationException {
        return Nudge.Companion.sendNudge(member, member.nudge());
    }

    /**
     * @return Group
     */
    public Group getGroup() {
        return member.getGroup();
    }


    /**
     * @return QQ号
     */
    public long getId() {
        return member.getId();
    }

    /**
     * @return 成员卡片
     */
    public String getNameCard() {
        return member.getNameCard();
    }

    /**
     * @param s 群卡片
     * @throws PermissionDeniedException - 无权限修改时
     */
    public void setNameCard(String s) throws PermissionDeniedException {
        member.setNameCard(s);
    }

    /**
     * @return 成员的权限
     */
    public MemberPermission getPermission() {
        return member.getPermission();
    }

    /**
     * @return 成员头像的URL
     */

    public String getAvatarUrl() {
        return member.getAvatarUrl();
    }

    /**
     * @return 成员的昵称
     */

    public String getNick() {
        return member.getNick();
    }

    /**
     * @return Bot
     */
    public Bot getBot() {
        return member.getBot();
    }

    /**
     * @return 成员的权限
     */
    public MemberPermission getBotPermission() {
        return member.getPermission();
    }

    /**
     * @return 成员的禁言时间
     */
    public int getMuteTimeRemaining() {
        return member.getMuteTimeRemaining();
    }

    /**
     * @return 群头衔
     */
    public String getSpecialTitle() {
        return member.getSpecialTitle();
    }

    /**
     * @param s 群名片
     * @throws PermissionDeniedException 无权限修改时抛
     */
    public void setSpecialTitle(String s) throws PermissionDeniedException {
        member.setSpecialTitle(s);
    }
}
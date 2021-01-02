package edu.sdust.moon.Response;

import edu.sdust.moon.Core.Message;
import edu.sdust.moon.Utils.SoundUtils;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.contact.*;
import net.mamoe.mirai.data.MemberInfo;
import net.mamoe.mirai.event.events.EventCancelledException;
import net.mamoe.mirai.event.events.GroupEvent;
import net.mamoe.mirai.message.GroupMessageEvent;
import net.mamoe.mirai.message.action.Nudge;
import net.mamoe.mirai.message.data.*;
import net.mamoe.mirai.utils.OverFileSizeMaxException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * GroupResponse Group的响应类
 * @author Moon
 */
public class GroupResponse extends Response {
    private Group group;
    private GroupEvent event;

    /**
     * 发送群消息
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */
    public void sendMessage(String message) throws EventCancelledException {
        try {
            Message.createMessage(
                    group.sendMessage(
                            MessageUtils.newChain(message)
                    ).getSource()
            );
        } catch (EventCancelledException e) {
            throw e;
        }
    }

    /**
     * 发送群消息并立即撤回
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */
    public void sendMessageRecall(String message) throws EventCancelledException {
        group.sendMessage(MessageUtils.newChain(message)).recall();
    }

    /**
     * 发送群消息, 多少毫秒后撤回
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */
    public void sendMessageRecall(String message, long timeMillis) throws EventCancelledException {
        group.sendMessage(MessageUtils.newChain(message)).recallIn(timeMillis);
    }

    /**
     * 发送群消息并@某人
     *
     * @param message 消息数据
     * @param member  群成员(net.mamoe.mirai.contact)
     * @throws EventCancelledException 事件被取消
     */
    public void sendMessageWithAt(String message, Member member) throws EventCancelledException {
        Message.createMessage(
                group.sendMessage(
                        MessageUtils.newChain(message).plus(new At(member))
                ).getSource()
        );
    }

    /**
     * 发送群消息并@某人
     *
     * @param message 消息数据
     * @param qq      群成员的QQ
     * @throws EventCancelledException 事件被取消
     */
    public void sendMessageWithAt(String message, long qq) throws EventCancelledException {
        Message.createMessage(
                group.sendMessage(
                        MessageUtils.newChain(message).plus(
                                new At(group.get(qq))
                        )
                ).getSource()
        );
    }

    /**
     * 发送群消息并@某人
     * 此函数只有在 GroupMessageEvent 事件中有效
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */
    public void sendMessageWithAt(String message) throws EventCancelledException {
        if (event != null && event instanceof GroupMessageEvent) {
            Message.createMessage(
                    group.sendMessage(
                            MessageUtils.newChain(message).plus(
                                    new At(
                                            ((GroupMessageEvent) event).getSender()
                                    )
                            )
                    ).getSource()
            );
        }
    }

    /**
     * 发送群消息并回复某人
     * 此函数只有在 GroupMessageEvent 事件中有效
     *
     * @param message 消息数据
     * @throws EventCancelledException 事件被取消
     */
    public void sendMessageWithRecall(String message) throws EventCancelledException {
        if (event != null && event instanceof GroupMessageEvent) {
            Message.createMessage(
                    group.sendMessage(MessageUtils.newChain(
                            new QuoteReply(
                                    Objects.requireNonNull(
                                            ((GroupMessageEvent) event).getMessage().first(
                                                    OnlineMessageSource.Key
                                            )
                                    )
                            )
                    ).plus(message)).getSource()
            );
        }
    }

    /**
     * 发送  戳一戳
     *
     * @param member 群成员
     * @throws UnsupportedOperationException 当未使用 [安卓协议] MiraiProtocol.ANDROID_PHONE 时抛出
     */
    public boolean sendNudge(Member member) throws UnsupportedOperationException {
        return Nudge.Companion.sendNudge(member, member.nudge());
    }

    /**
     * 在群中发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendImage(File image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(
                group.sendMessage(
                        group.uploadImage(image)
                ).getSource()
        );
    }

    /**
     * 在群中发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendImage(URL image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(
                group.sendMessage(
                        group.uploadImage(
                                image
                        )
                ).getSource()
        );
    }

    /**
     * 在群中发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendImage(InputStream image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(
                group.sendMessage(
                        group.uploadImage(image)
                ).getSource()
        );
    }

    /**
     * 在群中发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendFlashImage(File image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(
                group.sendMessage(
                        FlashImage.from(group.uploadImage(image))
                ).getSource()
        );
    }

    /**
     * 在群中发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendFlashImage(URL image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(
                group.sendMessage(
                        FlashImage.from(group.uploadImage(image))
                ).getSource()
        );
    }

    /**
     * 在群中发送图片
     *
     * @param image 图片
     * @throws OverFileSizeMaxException 图片文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendFlashImage(InputStream image) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(
                group.sendMessage(
                        FlashImage.from(group.uploadImage(image))
                ).getSource()
        );
    }

    /**
     * 在群里发送语音
     * 上传一个语音消息以备发送.
     * 请手动关闭输入流
     * 请使用 amr 或 silk 格式
     *
     * @param in 语音文件的流
     * @throws OverFileSizeMaxException 文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendGroupSound(InputStream in) throws OverFileSizeMaxException, EventCancelledException {
        Message.createMessage(group.sendMessage(group.uploadVoice(in)).getSource());
    }

    /**
     * 在群里发送语音
     * 上传一个语音消息以备发送.
     * 请手动关闭输入流
     *
     * @param message 要转换的语音内容
     * @throws OverFileSizeMaxException 文件过大
     * @throws EventCancelledException  事件被取消
     */
    public void sendGroupSound(String message) throws OverFileSizeMaxException, EventCancelledException {
        try {
            ByteArrayInputStream in = SoundUtils.TTS(message);
            Message.createMessage(group.sendMessage(group.uploadVoice(in)).getSource());
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param event 继承自 GroupEvent
     */
    public GroupResponse(GroupEvent event) {
        this.event = event;
        this.group = event.getGroup();
    }

    /**
     * 构造器
     *
     * @param group net.mamoe.mirai.contact.Group
     */
    public GroupResponse(Group group) {
        this.group = group;
    }

    /**
     * @return 群头像下载链接.
     */
    public String getAvatarUrl() {
        return group.getAvatarUrl();
    }

    /**
     * @return Bot 在群内的 Member 实例
     */
    public Member getBotAsMember() {
        return group.getBotAsMember();
    }

    /**
     * @return 机器人被禁言还剩余多少秒
     */
    public int getBotMuteRemaining() {
        return group.getBotMuteRemaining();
    }

    /**
     * @return bot
     */

    public Bot getBot() {
        return group.getBot();
    }

    /**
     * @return 群号
     */
    public long getGroupId() {
        return group.getId();
    }

    /**
     * @return 群名
     */

    public String getName() {
        return group.getName();
    }

    /**
     * @param s 新的群名
     * @throws PermissionDeniedException - 无权限修改时将会抛出异常
     */
    public void setName(String s) throws PermissionDeniedException {
        group.setName(s);
    }

    /**
     * @return 群主的QQ号
     */
    public long getOwnerId() {
        return group.getOwner().getId();
    }

    /**
     * 通过QQ 获取某个群成员，如果不存在此成员则返回 null
     *
     * @param qq QQ
     * @return 群成员 Or null
     */
    public Member getOrNull(long qq) {
        return group.getOrNull(qq);
    }

    /**
     * 构造一个 Member. 非特殊情况请不要使用这个函数. 优先使用 getMember.
     *
     * @param memberInfo 群成员的信息
     * @return 群成员
     */
    public Member newMember(MemberInfo memberInfo) {
        return group.newMember(memberInfo);
    }

    /**
     * @return 群设置
     */
    public GroupSettings getSettings() {
        return group.getSettings();
    }

    /**
     * 让机器人退出这个群.
     *
     * @return true Or false
     */
    public boolean quit() {
        return group.quit();
    }

    /**
     * 通过QQ 判断某一成员是否存在
     *
     * @param qq QQ
     * @return true Or false
     */
    public boolean contains(long qq) {
        return group.contains(qq);
    }

    /**
     * @param qq QQ's Id
     * @return Member 群成员
     * @throws NoSuchElementException 没有这个成员
     */
    public Member getMember(long qq) throws NoSuchElementException {
        if (!contains(qq)) {
            throw new NoSuchElementException();
        }
        return group.get(qq);
    }

    /**
     * @param qq QQ's Id
     * @return Member 群成员
     * @throws NoSuchElementException 没有这个成员
     */
    public MemberResponse getMemberResponse(long qq) throws NoSuchElementException {
        if (!contains(qq)) {
            throw new NoSuchElementException();
        }
        return new MemberResponse(group.get(qq));
    }

    /**
     * 获取 群主的Member对象 若机器人是群主, 返回 [botAsMember]. 否则返回相应的成员
     *
     * @return 群主的Member对象
     */
    public Member getOwner() {
        return group.getOwner();
    }

    /**
     * 获取 群主的Member对象Response
     *
     * @return 群主的Member对象
     */
    public MemberResponse getOwnerResponse() {
        return new MemberResponse(group.getOwner());
    }

    /**
     * @return 群主的群卡片
     */
    public String getOwnerNameCard() {
        return group.getOwner().getNameCard();
    }

    /**
     * @return 机器人的权限
     */
    public MemberPermission getBotPermission() {
        return group.getBotPermission();
    }

    /**
     * @return Group's Id
     */
    public long getId() {
        return group.getId();
    }

    /**
     * @return 群成员列表
     */
    public ArrayList<Member> getMembers() {
        return new ArrayList<>(group.getMembers());
    }

    /**
     * @return 群成员列表
     */
    public ArrayList<MemberResponse> getMemberResponses() {
        ArrayList<MemberResponse> list = new ArrayList<>();
        for (var it : group.getMembers()) {
            list.add(new MemberResponse(it));
        }
        return list;
    }

    /**
     * 删除群中的某个成员
     *
     * @param qq 群成员qq
     * @throws PermissionDeniedException 无权限修改时
     * @throws NoSuchElementException    没有这个成员
     */
    public void deleteMember(long qq) throws PermissionDeniedException, NoSuchElementException {
        group.get(qq).kick();
    }

    /**
     * 禁言群中一成员
     *
     * @param qq   群成员qq
     * @param time 禁言时间(min)
     * @throws PermissionDeniedException 无权限修改时
     * @throws NoSuchElementException    没有这个成员
     */
    public void muteMember(long qq, int time) throws PermissionDeniedException, NoSuchElementException {
        group.get(qq).mute(time * 60);
    }

    /**
     * 取消禁言
     *
     * @param qq 群成员的qq
     * @throws PermissionDeniedException 无权限修改时
     * @throws NoSuchElementException    没有这个成员
     */
    public void unmuteMember(long qq) throws PermissionDeniedException, NoSuchElementException {
        group.get(qq).unmute();
    }

    /**
     * 群 全体禁言
     *
     * @throws PermissionDeniedException 无权限修改时
     */
    public void groupMuteAll() throws PermissionDeniedException {
        group.getSettings().setMuteAll(true);
    }

    /**
     * 取消 群 全体禁言
     *
     * @throws PermissionDeniedException 无权限修改时
     */
    public void groupUnmuteAll() throws PermissionDeniedException {
        group.getSettings().setMuteAll(false);
    }

    /**
     * 修改一成员的群名片
     *
     * @param qq   成员qq
     * @param card 群名片
     * @throws PermissionDeniedException 无权限修改时
     * @throws NoSuchElementException    没有这个成员
     */
    public void setGroupMemberCard(long qq, String card) throws PermissionDeniedException, NoSuchElementException {
        group.get(qq).setNameCard(card);
    }

    /**
     * 修改群名
     *
     * @param name 新的群名
     * @throws PermissionDeniedException 无权限修改时
     * @throws EventCancelledException   事件被取消
     */
    public void setGroupName(String name) throws PermissionDeniedException, EventCancelledException {
        group.setName(name);
    }

}
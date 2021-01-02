package edu.sdust.moon.Core;

import net.mamoe.mirai.contact.PermissionDeniedException;
import net.mamoe.mirai.message.data.Face;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.MessageSource;
import net.mamoe.mirai.message.data.PlainText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 消息处理的类
 *
 * @author Moon
 */
public class Message {
    private static final Map<Integer, MessageSource> MessageList = new HashMap<>();


    /**
     * @param source 消息
     * @return 如果此消息已经实例化，则返回已实例化的对象，否则返回的实例化对象,
     * 并储存。有低概率 source 获取其Id错误
     */
    public static MessageSource createMessage(MessageSource source) {
        MessageSource messageCall = null;
        int id = source.getId();
        if (id != -1) {
            if (MessageList.containsKey(id)) {
                messageCall = MessageList.get(id);
            } else {
                MessageList.put(id, source);
            }
        }
        return messageCall;
    }

    /**
     * 撤回消息
     *
     * @return 撤回成功，则返回true；否则返回false
     * @throws PermissionDeniedException    当 Bot 无权限操作时抛出
     * @throws IllegalStateException    当这条消息已经被撤回时抛出(仅同步主动操作)
     */
    public static boolean reCall(MessageSource source) throws PermissionDeniedException, IllegalStateException {
        boolean is = false;
        if (source.getTime() < 3 * 60 * 100) {
            source.contentEquals("", true);
            source.getBot().recall(source);
            MessageList.remove(source.getId());
            is = true;
        }
        return is;
    }

    /**
     * 获取消息的所有的 Face
     * @param message 消息
     * @return Face 的 List 集合
     */
    public static List<Face> getFace(MessageChain message) {
        ArrayList<Face> faces=new ArrayList<>();
        message.forEach(item->{
            if (Face.class==item.getClass()){
                faces.add((Face)item);
            }
        });
        return  faces;
    }


    /**
     * 获取消息的所有的 PlainText
     * @param message 消息
     * @return PlainText 的 List 集合
     */
    public  static List<PlainText> getPlainText(MessageChain message) {
        ArrayList<PlainText> faces=new ArrayList<>();
        message.forEach(item->{
            if (PlainText.class==item.getClass()){
                faces.add((PlainText)item);
            }
        });
        return  faces;
    }

}
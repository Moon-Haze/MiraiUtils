package edu.sdust.moon.EventListener;

import net.mamoe.mirai.event.EventHandler;
import net.mamoe.mirai.event.ListeningStatus;
import net.mamoe.mirai.event.events.BeforeImageUploadEvent;
import net.mamoe.mirai.event.events.ImageUploadEvent;

/**
 * 图片上传事件监听类
 * @author Moon
 */
public class ImageUploadEventListener extends EventListener {


    /**
     * [机器人]图片上传前. 可以阻止上传（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus BeforeImageUploadEvent(BeforeImageUploadEvent event) {
        return ListeningStatus.LISTENING;
    }


    /**
     * [机器人]图片上传成功（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus ImageUploadSucceedEvent(ImageUploadEvent.Succeed event) {
        return ListeningStatus.LISTENING;
    }

    /**
     * [机器人]图片上传失败（事件）
     *
     * @param event
     * @return
     */
    @EventHandler
    public ListeningStatus ImageUploadFailedEvent(ImageUploadEvent.Failed event) {
        return ListeningStatus.LISTENING;
    }
}
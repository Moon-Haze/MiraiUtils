package edu.sdust.moon.EventListener;

import edu.sdust.moon.Core.QQBot;
import kotlin.coroutines.CoroutineContext;
import net.mamoe.mirai.event.SimpleListenerHost;
import org.jetbrains.annotations.NotNull;


/**
 * 事件监听类的所有父类
 *
 * @author Moon
 */
public class EventListener extends SimpleListenerHost {

    /**
     * 处理在处理事件中发生的未捕获异常
     *
     * @param context   ......
     * @param exception ......
     */
    @Override
    public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
        QQBot.getLogger().error("在事件处理中发生异常" + "\n" + context, exception);
    }
}

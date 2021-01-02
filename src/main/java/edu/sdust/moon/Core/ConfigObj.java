package edu.sdust.moon.Core;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置信息文件映射类
 *
 * @author Moon
 */
public class ConfigObj {
    private List<QQObj> QQs;

    /**
     *
     * @return QQ 对应的 QQObj 对象
     */
    public List<QQObj> getQQs() {
        return QQs;
    }

    /**
     *
     * @param QQs 设置 List<QQObj>
     */
    public void setQQs(List<QQObj> QQs) {
        this.QQs = QQs;
    }

    /**
     * 构造器
     */
    public ConfigObj() {
        QQs = new ArrayList<>() {{
            add(new QQObj(0, null));
        }};
    }

    /**
     * 构造器
     * @param QQs QQObj的 List 集合
     * @param pack
     */
    public ConfigObj(List<QQObj> QQs, boolean pack) {
        this.QQs = QQs;
    }

    /**
     * 通过 qq 获取 其QQ号对应的QQObj 对象
     * @param qq qq
     * @return
     */
    public QQObj getQQ(long qq) {
        for (QQObj QQ : QQs) {
            if (QQ.getQQ() == qq) {
                return QQ;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "ConfigObj{" +
                "QQs=" + QQs +
                '}';
    }
}

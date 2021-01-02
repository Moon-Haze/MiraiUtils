package edu.sdust.moon.Core;

/**
 * 每一QQ的配置信息
 *
 * @author Moon
 */
public class QQObj {
    private long QQ;
    private String password;
    private int type;

    /**
     *
     * @return qq
     */
    public long getQQ () {
        return QQ;
    }

    /**
     *
     * @return Password
     */
    public String getPassword () {
        return password;
    }

    /**
     *
     * @return 登录协议
     */
    public int getType() {
        return type;
    }

    /**
     * 设置 登录协议
     * 0 为 手机 ( MiraiProtocol.ANDROID_PHONE )
     * 1 为 手表 ( MiraiProtocol.ANDROID_WATCH )
     * 2 为 平板 ( MiraiProtocol.ANDROID_PAD )
     * @param type 登录协议
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * 构造器
     * @param QQ QQ
     * @param password password
     */
    public QQObj(long QQ, String password) {
        this.QQ = QQ;
        if (password == null) {
            this.password = "Please type in your password.";
        } else {
            this.password = password;
            this.type=0;
        }
    }
    @Override
    public String toString () {
        return "QQsObj{" +
                "QQ=" + QQ +
                ", Password='" + password + '\'' +
                ", Type'" + type +
                '}';
    }
}

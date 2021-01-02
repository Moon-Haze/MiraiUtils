package edu.sdust.moon.Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 文字转化为语音的Util类
 *
 * @author Moon
 */
public class SoundUtils {
    /**
     *
     * @param str 文字内容
     * @return 流
     * @throws IOException URL IO
     */
    public static ByteArrayInputStream TTS(String str) throws IOException {
        URL url = new URL("https://tts.baidu.com/text2audio?cuid=baike&lan=zh&ctp=1&pdt=301&rate=32&per=5118&tex="
                + URLEncoder.encode(str, StandardCharsets.UTF_8));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(5 * 1000);
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream inputStream = conn.getInputStream();
        byte[] bytes =inputStream.readAllBytes();
        ByteArrayInputStream input=new ByteArrayInputStream(bytes);
        inputStream.close();
        return input;
    }
}

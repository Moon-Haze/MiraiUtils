package edu.sdust.moon.Utils;

import com.alibaba.fastjson.JSON;
import edu.sdust.moon.Core.ConfigObj;

import java.io.*;
import java.nio.charset.StandardCharsets;


/**
 * Config 文件的读取写入Util类
 * @author Moon
 */
public class ConfigReadUtil {
    public static ConfigObj readConfig(String local) {
        ConfigObj configObj = null;
        File configFile = null;
        try {
            configFile = new File(local + "/config/config.json");
            if (!configFile.exists()) {
                if (!configFile.getParentFile().exists()) {
                    configFile.getParentFile().mkdirs();
                }
                configFile.createNewFile();
                configObj = new ConfigObj();
                Save(configFile,configObj);
            } else {
                var reader = new InputStreamReader(
                        new FileInputStream(configFile), StandardCharsets.UTF_8);
                var bf = new BufferedReader(reader);
                StringBuilder stringBuilder = new StringBuilder();
                String str = "";
                while ((str = bf.readLine()) != null) {
                    stringBuilder.append(str);
                }
                configObj = JSON.parseObject(stringBuilder.toString(), ConfigObj.class);
                if (configObj.getQQs() == null) {
                    configObj = new ConfigObj();
                    Save(configFile,configObj);
                }
                bf.close();
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configObj;
    }

    public static void Save(File configFile, ConfigObj configObj) throws IOException {
        FileOutputStream out = new FileOutputStream(configFile);
        OutputStreamWriter write = new OutputStreamWriter(
                out, StandardCharsets.UTF_8);
        write.write(JSON.toJSONString(configObj));
        write.close();
        out.close();
    }
}

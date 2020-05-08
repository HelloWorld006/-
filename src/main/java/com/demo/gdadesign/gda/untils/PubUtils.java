package com.demo.gdadesign.gda.untils;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class PubUtils {
    /**
     * 数据返回格式统一
     * @param msg
     * @param code
     * @param data
     * @return
     */
    public static JSONObject getReturnData(String msg, Integer code, Map<String, Object> data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("date", getNowDate());
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        jsonObject.put("data", data);
        return jsonObject;
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        return format;
    }

    /**
     * 获取uuid
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}

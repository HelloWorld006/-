package com.demo.gdadesign.gda.untils;

import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class PubUtils {
    public static JSONObject getReturnData(String msg, Integer code, Map<String, Object> data) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("date", getNowDate());
        jsonObject.put("code", code);
        jsonObject.put("msg", msg);
        jsonObject.put("data", data);
        return jsonObject;
    }

    public static String getNowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        return format;
    }
}

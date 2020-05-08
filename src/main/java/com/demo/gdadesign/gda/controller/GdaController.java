package com.demo.gdadesign.gda.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.demo.gdadesign.gda.entity.GdaEntity;
import com.demo.gdadesign.gda.service.GdaService;
import com.demo.gdadesign.gda.untils.PubUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gda")
public class GdaController {
    @Autowired
    private GdaService gdaService;

    /**
     * 遍历
     * @param title
     * @return
     */
    @GetMapping("/list")
    public JSONObject login(String title) {
        List<GdaEntity> list = gdaService.list(title);
        if (list.size() == 0 || list == null) {
            return PubUtils.getReturnData("无数据", 500, null);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("data", list);
            return PubUtils.getReturnData("success", 200, map);
        }

    }

    /**
     * 新增或者编辑
     * @param jsonObject
     * @return
     */
    @PostMapping("/doAddOrUpdate")
    public JSONObject doAddOrUpdate(@RequestBody JSONObject jsonObject) {
        GdaEntity gdaEntity = JSON.parseObject(jsonObject.toJSONString(), GdaEntity.class);
        String s = gdaService.doAddOrUpdate(gdaEntity);
        if (s.contains("成功")) {
            return PubUtils.getReturnData(s, 200, null);
        } else {
            return PubUtils.getReturnData(s, 500, null);
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @GetMapping("/doDelete")
    public JSONObject doDelete(String id) {
        String s = gdaService.doDelete(id);
        if ("success".equals(s)) {
            return PubUtils.getReturnData(s, 200, null);
        } else {
            return PubUtils.getReturnData(s, 500, null);
        }
    }

    @GetMapping("/goUpdate")
    public JSONObject goUpdate(String id) {
        GdaEntity gdaEntity = gdaService.goUpdate(id);
        if (gdaEntity==null) {
            return PubUtils.getReturnData("没有数据", 500, null);
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("data", gdaEntity);
            return PubUtils.getReturnData("success", 200, map);
        }
    }
}

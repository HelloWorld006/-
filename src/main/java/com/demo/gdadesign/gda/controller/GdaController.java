package com.demo.gdadesign.gda.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.gdadesign.gda.entity.GdaEntity;
import com.demo.gdadesign.gda.service.GdaService;
import com.demo.gdadesign.gda.untils.PubUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gda")
public class GdaController {
    @Autowired
    private GdaService gdaService;

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
}

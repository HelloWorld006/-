package com.demo.gdadesign.gda.service;

import com.demo.gdadesign.gda.entity.GdaEntity;

import java.util.List;

public interface GdaService {
    List<GdaEntity> list(String title,Integer page,Integer size);

    String doAddOrUpdate(GdaEntity entity);

    String doDelete(String id);

    GdaEntity goUpdate(String id);
}

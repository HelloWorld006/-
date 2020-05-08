package com.demo.gdadesign.gda.service;

import com.demo.gdadesign.gda.entity.GdaEntity;

import java.util.List;

public interface GdaService {
    List<GdaEntity> list(String title);

    String doAddOrUpdate(GdaEntity entity);

    String doDelete(String id);
}

package com.demo.gdadesign.gda.service.impl;

import com.demo.gdadesign.gda.dao.GdaDao;
import com.demo.gdadesign.gda.entity.GdaEntity;
import com.demo.gdadesign.gda.service.GdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GdaServiceImpl implements GdaService {
    @Autowired
    private GdaDao gdaDao;

    /**
     * 遍历展示
     * @param title
     * @return
     */
    @Override
    public List<GdaEntity> list(String title) {
        List<GdaEntity> list = gdaDao.list(title);
        return list;
    }

    @Override
    public String doAddOrUpdate(GdaEntity entity) {
        return null;
    }

    @Override
    public String doDelete(String id) {
        return null;
    }
}

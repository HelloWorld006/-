package com.demo.gdadesign.gda.service.impl;

import com.demo.gdadesign.gda.dao.GdaDao;
import com.demo.gdadesign.gda.entity.GdaEntity;
import com.demo.gdadesign.gda.service.GdaService;
import com.demo.gdadesign.gda.untils.PubUtils;
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
    public List<GdaEntity> list(String title, Integer page, Integer size) {
        List<GdaEntity> list = gdaDao.list(title,page,size);
        return list;
    }

    @Override
    public String doAddOrUpdate(GdaEntity entity) {
        if (entity.getId() == null) {
            //新增
            entity.setId(PubUtils.getUUID());
            boolean b = gdaDao.saveOrUpdate(entity);
            if (b) {
                return "添加成功";
            } else {
                return "添加失败";
            }

        } else {
            //编辑
            boolean b = gdaDao.saveOrUpdate(entity);
            if (b) {
                return "编辑成功";
            } else {
                return "编辑失败";
            }
        }
    }

    @Override
    public String doDelete(String id) {
        boolean delete = gdaDao.delete(id);
        if (delete) {
            return "success";
        }
        return "删除失败";
    }

    @Override
    public GdaEntity goUpdate(String id) {
        return gdaDao.goUpdate(id);
    }
}

package com.demo.gdadesign.gda.dao;

import com.demo.gdadesign.gda.entity.GdaEntity;
import com.demo.gdadesign.gda.repository.GdaRepository;
import com.demo.gdadesign.gda.shard.SharedData;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public class GdaDao {

    /**
     * gda项目遍历
     *
     * @param title
     * @return
     */
    public List<GdaEntity> list(String title,Integer page,Integer size) {
        GdaRepository gdaRepository = SharedData.getSharedData().getGdaRepository();
        if (StringUtils.isEmpty(title)) {
            //如果是初始化遍历 则全部查找
//            List<GdaEntity> all = gdaRepository.findAll();
            List<GdaEntity> by = gdaRepository.findBy(PageRequest.of(page, size));
            return by;
        } else {
            //搜索查找
            return gdaRepository.findAllByTitleLike("%" + title + "%");
        }
    }

    /**
     * 添加或者编辑
     * @param entity
     * @return
     */
    public boolean saveOrUpdate(GdaEntity entity) {
        GdaRepository gdaRepository = SharedData.getSharedData().getGdaRepository();
        if (StringUtils.isEmpty(entity)) {
            //如果是初始化遍历 则全部查找
            gdaRepository.saveAndFlush(entity);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除功能
     * @param id
     * @return
     */
    public boolean delete(String id) {
        try {
            GdaRepository gdaRepository = SharedData.getSharedData().getGdaRepository();
            gdaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 查询功能
     * @param id
     * @return
     */
    public GdaEntity goUpdate(String id) {
        try {
            GdaRepository gdaRepository = SharedData.getSharedData().getGdaRepository();
            GdaEntity gdaEntity = gdaRepository.findById(id).get();
            return gdaEntity;
        } catch (Exception e) {
            return null;
        }
    }

}

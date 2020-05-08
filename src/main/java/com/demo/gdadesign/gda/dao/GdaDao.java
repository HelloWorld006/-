package com.demo.gdadesign.gda.dao;

import com.demo.gdadesign.gda.entity.GdaEntity;
import com.demo.gdadesign.gda.repository.GdaRepository;
import com.demo.gdadesign.gda.shard.SharedData;
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
    public List<GdaEntity> list(String title) {
        GdaRepository gdaRepository = SharedData.getSharedData().getGdaRepository();
        if (StringUtils.isEmpty(title)) {
            //如果是初始化遍历 则全部查找
            List<GdaEntity> all = gdaRepository.findAll();
            return all;
        } else {
            //搜索查找
            return gdaRepository.findAllByTitleLike("%" + title + "%");
        }
    }
}

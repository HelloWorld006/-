package com.demo.gdadesign.gda.repository;

import com.demo.gdadesign.gda.entity.GdaEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GdaRepository extends JpaRepository<GdaEntity,String> {
    List<GdaEntity> findAllByTitleLike(String title);

    List<GdaEntity> findBy(Pageable pageable);
}

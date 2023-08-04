package com.idLogin.idLogin.repository;

import com.idLogin.idLogin.entity.MDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MDataRepository extends JpaRepository<MDataEntity, Long> {
    @Query("SELECT m FROM MDataEntity m")
    List<MDataEntity> printm();

}

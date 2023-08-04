package com.idLogin.idLogin.repository;

import com.idLogin.idLogin.entity.SDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SDataRepository extends JpaRepository<SDataEntity, Long> {
    @Query("SELECT s FROM SDataEntity s")
    List<SDataEntity> prints();

}

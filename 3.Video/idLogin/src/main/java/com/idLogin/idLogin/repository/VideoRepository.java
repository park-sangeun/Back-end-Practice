package com.idLogin.idLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idLogin.idLogin.entity.Files;

public interface VideoRepository extends JpaRepository<Files, Integer> {
    Files findByFno(int fno);
}

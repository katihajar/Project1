package com.example.project1.dao;

import com.example.project1.bean.ImageModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageModelDao extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByName(String name);
}

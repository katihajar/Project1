package com.example.project1.dao;
import com.example.project1.bean.Tresorerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TresorerieDao extends JpaRepository<Tresorerie, Long> {
    List<Tresorerie> findByComiteMission(String mission);
    int deleteTresorerieById(Long id);
}

package com.example.project1.dao;

import com.example.project1.bean.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActiviteDao  extends JpaRepository<Activite, Long> {
    List<Activite> findByClubsLibelle(String libelle);

}

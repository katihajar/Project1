package com.example.project1.Dao;

import com.example.project1.Bean.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActiviteDao  extends JpaRepository<Activite, Long> {
    List<Activite> findByClubsLibelle(String libelle);

}

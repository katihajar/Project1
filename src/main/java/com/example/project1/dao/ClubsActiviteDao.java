package com.example.project1.dao;

import com.example.project1.bean.Clubs;
import com.example.project1.bean.ClubsActivite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubsActiviteDao extends JpaRepository<ClubsActivite, Long> {
    int deleteClubsActiviteById(Long id);
    List<ClubsActivite> findByClubsLibelle(String libelle);
    List<ClubsActivite> findByActiviteNomActivite(String nomActivite);
}
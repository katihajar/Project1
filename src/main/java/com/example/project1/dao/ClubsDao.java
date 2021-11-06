package com.example.project1.dao;

import com.example.project1.bean.Clubs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubsDao extends JpaRepository<Clubs, Long> {
    int deleteClubsById(Long id);
    Clubs findByLibelle(String libelle);
    Clubs findClubsById(Long id);
    List<Clubs> findByCategorie(String categorie);
    List<Clubs> findByReferentPedagogique(String referentPedagogique);
}

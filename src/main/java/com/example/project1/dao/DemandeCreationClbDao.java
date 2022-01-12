package com.example.project1.dao;

import com.example.project1.bean.Clubs;
import com.example.project1.bean.DemandeCreationClb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface DemandeCreationClbDao extends JpaRepository<DemandeCreationClb, Long> {
    int deleteDemandeCreationClbById(Long id);
    int deleteByLibelle(String libelle);
    DemandeCreationClb findByLibelle(String libelle);
    DemandeCreationClb findDemandeCreationClbById(Long id);
    List<DemandeCreationClb> findByCategorie(String categorie);
}
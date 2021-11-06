package com.example.project1.dao;

import com.example.project1.bean.Activite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActiviteDao  extends JpaRepository<Activite, Long> {
    Activite findByNomActivite(String nomActivite);
    List<Activite> findByClubsLibelle(String libelle);
    List<Activite> findByClubsCategorie(String categorie);
    Activite findActiviteById(Long id);
    int deleteActiviteById(Long id);

}

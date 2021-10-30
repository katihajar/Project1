package com.example.project1.dao;

import com.example.project1.bean.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantDao extends JpaRepository<Etudiant, Long> {
    int deleteEtudiantById(Long id);
    Etudiant findByNomAndPrenom(String nom,String prenom);
    Etudiant findByLogin(String login);
    Etudiant findEtudiantById(Long id);
}

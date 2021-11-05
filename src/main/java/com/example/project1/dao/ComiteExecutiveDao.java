package com.example.project1.dao;

import com.example.project1.bean.ComiteExecutive;
import com.example.project1.bean.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComiteExecutiveDao extends JpaRepository<ComiteExecutive, Long> {
    int deleteComiteExecutiveById(Long id);
    List<ComiteExecutive> findByClubsLibelle(String libelle);
    ComiteExecutive findByNumeroEtudiant(String numeroEtudiant);
}

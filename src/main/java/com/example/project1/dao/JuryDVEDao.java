package com.example.project1.dao;
import com.example.project1.bean.JuryDVE;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JuryDVEDao extends JpaRepository<JuryDVE, Long> {
    int deleteJuryDVEById(Long id);
    JuryDVE findByNomAndPrenom(String nom, String prenom);
    JuryDVE findJuryDVEById(Long id);
}

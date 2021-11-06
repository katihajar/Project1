package com.example.project1.dao;
import com.example.project1.bean.JuryDVE;
import com.example.project1.bean.SuperAdminDVE;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperAdminDVEDao extends JpaRepository<SuperAdminDVE, Long> {
    int deleteSuperAdminDVEById(Long id);
    SuperAdminDVE findByNomAndPrenom(String nom, String prenom);
    SuperAdminDVE findSuperAdminDVEById(Long id);
}

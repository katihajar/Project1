package com.example.project1.dao;

import com.example.project1.bean.ClubsMembers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubsMembersDao extends JpaRepository<ClubsMembers, Long> {
    int deleteClubsActiviteById(Long id);
    List<ClubsMembers> findByClubsLibelle(String libelle);
    ClubsMembers findClubsMembersById(Long id);
    List<ClubsMembers> findByMemberId(Long id);
    List<ClubsMembers> findByMemberNumeroEtudiant(String numeroEtudiant);

}
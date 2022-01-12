package com.example.project1.dao;

import com.example.project1.bean.Clubs;
import com.example.project1.bean.ClubsMembers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface ClubsMembersDao extends JpaRepository<ClubsMembers, Long> {
    int deleteClubsActiviteById(Long id);
    int deleteByClubsId(Long id);
    List<ClubsMembers> findByClubsLibelle(String libelle);
    ClubsMembers findByClubsIdAndStatus(Long id,String status);
    List<ClubsMembers> findByClubsLibelleAndEtatAndClubsStatus(String libelle, Boolean etat, String status);
    ClubsMembers findClubsMembersById(Long id);
    List<ClubsMembers> findByMemberId(Long id);
    List<ClubsMembers> findByMemberIdAndEtat(Long id, Boolean etat);
    List<ClubsMembers> findByMemberIdAndEtatAndClubsStatus(Long id, Boolean etat, String status);
    List<ClubsMembers> findByEtat( Boolean etat);
    List<ClubsMembers> findByMemberNumeroEtudiant(String numeroEtudiant);
    List<ClubsMembers> findClubsMembersByClubsIdNotInAndEtat(ArrayList<Long> ids, boolean etat);
}
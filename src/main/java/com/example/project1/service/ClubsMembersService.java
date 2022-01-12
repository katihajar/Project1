package com.example.project1.service;

import com.example.project1.bean.Clubs;
import com.example.project1.bean.ClubsMembers;
import com.example.project1.bean.Member;
import com.example.project1.bean.Tresorerie;
import com.example.project1.dao.ClubsMembersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClubsMembersService {
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ClubsMembersDao clubsMembersDao;
    @Autowired
    private ClubsService clubsService;
    @Autowired
    private MemberService memberService;
    @Transactional
    public int deleteByClubsId(Long id) {
        return clubsMembersDao.deleteByClubsId(id);
    }

    public ClubsMembers findClubsMembersById(Long id) {
        return clubsMembersDao.findClubsMembersById(id);
    }
    @Transactional
    public int deleteListClubsActiviteById(List<ClubsMembers> clubsMembers) {
        int res=0;
        for (int i = 0; i < clubsMembers.size(); i++) {
            res+=deleteClubsActiviteById(clubsMembers.get(i).getId());
        }
        return res;
    }
    @Transactional
    public int deleteClubsActiviteById(Long id) {
        return clubsMembersDao.deleteClubsActiviteById(id);
    }

    public List<ClubsMembers> findByClubsLibelle(String libelle) {
        return clubsMembersDao.findByClubsLibelle(libelle);
    }

    public ClubsMembers findByClubsIdAndStatus(Long id, String status) {
        return clubsMembersDao.findByClubsIdAndStatus(id, status);
    }

    public List<ClubsMembers> findByMemberNumeroEtudiant(String numeroEtudiant) {
        return clubsMembersDao.findByMemberNumeroEtudiant(numeroEtudiant);
    }

    public List<ClubsMembers> findByMemberId(Long id) {
        return clubsMembersDao.findByMemberId(id);
    }

    public List<ClubsMembers> findByClubsLibelleAndEtatAndClubsStatus(String libelle, Boolean etat, String status) {
        return clubsMembersDao.findByClubsLibelleAndEtatAndClubsStatus(libelle, etat, status);
    }

    public List<ClubsMembers> findByMemberIdAndEtatAndClubsStatus(Long id, Boolean etat, String status) {
        return clubsMembersDao.findByMemberIdAndEtatAndClubsStatus(id, etat, status);
    }

    public List<ClubsMembers> findByEtat(Boolean etat) {
        return clubsMembersDao.findByEtat(etat);
    }

    public List<ClubsMembers> findByMemberIdAndEtat(Long id, Boolean etat) {
        return clubsMembersDao.findByMemberIdAndEtat(id, etat);
    }

    public List<ClubsMembers> findAll() {
        return clubsMembersDao.findAll();
    }

    public int save(ClubsMembers clubsMembers) {
        if (findClubsMembersById(clubsMembers.getId())!= null){
            return -1;
        }else {
            clubsMembers.setEtat(Boolean.FALSE);
            clubsMembersDao.save(clubsMembers);
            return 1;
        }
    }
    public List<Long> findByCritere(Long id) {
        String query = "SELECT a.clubs.id FROM ClubsMembers a WHERE a.member.id ='"+ id + "'";
        return entityManager.createQuery(query).getResultList();
    }

    public List<ClubsMembers> findClubsMembersByClubsIdNotInAndEtat(ArrayList<Long> ids, boolean etat) {
        return clubsMembersDao.findClubsMembersByClubsIdNotInAndEtat(ids, etat);
    }

    public ClubsMembers update(ClubsMembers clubsMembers) {
        Member member= memberService.findMemberById(clubsMembers.getMember().getId());
        Clubs clubs= clubsService.findClubsById(clubsMembers.getClubs().getId());
        ClubsMembers clbM = findByClubsIdAndStatus(clubsMembers.getClubs().getId(),"Président");
        if(clbM != null && clubsMembers.getStatus().equals("Président")){
            clbM.setStatus("membre");
            clubsMembersDao.save(clbM);
        }
        ClubsMembers clbM2 = findByClubsIdAndStatus(clubsMembers.getClubs().getId(),"Tresor");
        if(clbM2 != null && clubsMembers.getStatus().equals("Tresor")){
            clbM2.setStatus("membre");
            clubsMembersDao.save(clbM2);
        }
        clubsMembers.setMember(member);
        clubsMembers.setClubs(clubs);
        clubsMembers.setEtat(clubsMembers.getEtat());
        clubsMembers.setStatus(clubsMembers.getStatus());
        return clubsMembersDao.save(clubsMembers);
    }
}

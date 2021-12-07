package com.example.project1.service;

import com.example.project1.bean.Clubs;
import com.example.project1.bean.ClubsMembers;
import com.example.project1.bean.Member;
import com.example.project1.bean.Tresorerie;
import com.example.project1.dao.ClubsMembersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClubsMembersService {
    @Autowired
    private ClubsMembersDao clubsMembersDao;
    @Autowired
    private ClubsService clubsService;
    @Autowired
    private MemberService memberService;

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

    public List<ClubsMembers> findByMemberNumeroEtudiant(String numeroEtudiant) {
        return clubsMembersDao.findByMemberNumeroEtudiant(numeroEtudiant);
    }

    public List<ClubsMembers> findByMemberId(Long id) {
        return clubsMembersDao.findByMemberId(id);
    }

    public List<ClubsMembers> findAll() {
        return clubsMembersDao.findAll();
    }

    public int save(ClubsMembers clubsMembers) {
        if (findClubsMembersById(clubsMembers.getId())!= null){
            return -1;
        }else {
            clubsMembersDao.save(clubsMembers);
            return 1;
        }
    }

    public ClubsMembers update(ClubsMembers clubsMembers) {
        Member member= memberService.findMemberById(clubsMembers.getMember().getId());
        Clubs clubs= clubsService.findClubsById(clubsMembers.getClubs().getId());
        clubsMembers.setMember(member);
        clubsMembers.setClubs(clubs);
        clubsMembers.setStatus(clubsMembers.getStatus());
        return clubsMembersDao.save(clubsMembers);
    }
}

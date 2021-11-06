package com.example.project1.service;

import com.example.project1.bean.Clubs;
import com.example.project1.bean.Member;
import com.example.project1.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public Member findMemberById(Long id) {
        return memberDao.findMemberById(id);
    }


    public Member findBynumeroEtudiant(String numeroEtudiant) {
        return memberDao.findBynumeroEtudiant(numeroEtudiant);
    }
    @Transactional
    public int deleteListMemberById(List<Member> member) {
        int res=0;
        for (int i = 0; i < member.size(); i++) {
            res+=deleteMemberById(member.get(i).getId());
        }
        return res;
    }
    @Transactional
    public int deleteMemberById(Long id) {
        return memberDao.deleteMemberById(id);
    }

    public List<Member> findAll() {
        return memberDao.findAll();
    }

    public int save(Member member) {
       if (findMemberById(member.getId())!=null){
           return -1;
       }else {
           memberDao.save(member);
           return 1;
       }
    }
    public Member update(Member member) {
        member.setFillier(member.getFillier());
        member.setLogin(member.getLogin());
        member.setPassword(member.getPassword());
        member.setNom(member.getNom());
        member.setPrenom(member.getPrenom());
        member.setNiveau(member.getNiveau());
        return memberDao.save(member);
    }
}

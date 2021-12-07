package com.example.project1.service;

import com.example.project1.bean.Clubs;
import com.example.project1.bean.Member;
import com.example.project1.dao.MemberDao;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.security.SecureRandom;
import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    public JavaMailSender mailSender;
    public Object findByCritere(String login, String password) {
        String query = "SELECT a FROM Member a WHERE a.login= '" + login + "' and a.password='"+ password + "'";
        return entityManager.createQuery(query).getSingleResult();
    }
    private void prepareMessage(Member member) {
        System.out.println("prepare email ");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("hakati1999@gmail.com");
        message.setTo(member.getLogin());
        message.setSubject("accepted on the platform UIRClubs");
        message.setText("you have been accepted on the UIRClubs platform. \n" +
                "username : "+ member.getLogin() +"\n"+
                "password : "+ member.getPassword());
        mailSender.send(message);
        System.out.println("email send");

    }
    public Member findMemberById(Long id) {
        return memberDao.findMemberById(id);
    }

    public Member findMemberByLogin(String login) {
        return memberDao.findMemberByLogin(login);
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
        if (findMemberByLogin(member.getLogin())!=null){
            return -1;
        }
      else if (findMemberById(member.getId())!=null){
           return -2;
       }else {
           char[] possibleCharacters = (new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~&*")).toCharArray();
           String pass = RandomStringUtils.random( 10, 0, possibleCharacters.length-1, false, false, possibleCharacters, new SecureRandom() );
           member.setPassword(pass);
           memberDao.save(member);
           prepareMessage(member);
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

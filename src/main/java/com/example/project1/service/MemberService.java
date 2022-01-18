package com.example.project1.service;

import com.example.project1.bean.Member;
import com.example.project1.dao.MemberDao;
import com.example.project1.exception.NotAnImageFileException;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;

import static com.example.project1.filter.JwtConstant.*;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.MediaType.*;

@Service
public class MemberService {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    public JavaMailSender mailSender;

    public Member findByNom(String username) {
        return memberDao.findByNom(username);
    }

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

    private void saveProfileImage(Member user, MultipartFile profileImage) throws IOException, NotAnImageFileException {

        System.out.println(user.getNom());
        if (profileImage != null) {
            if (!Arrays.asList(IMAGE_JPEG_VALUE, IMAGE_PNG_VALUE, IMAGE_GIF_VALUE).contains(profileImage.getContentType())) {
                throw new NotAnImageFileException(profileImage.getOriginalFilename() + NOT_AN_IMAGE_FILE);
            }
            Path userFolder = Paths.get(USER_FOLDER + user.getNom()).toAbsolutePath().normalize();
            if (!Files.exists(userFolder)) {
                Files.createDirectories(userFolder);
                LOGGER.info(DIRECTORY_CREATED + userFolder);
            }
            Files.deleteIfExists(Paths.get(userFolder + user.getNom() + DOT + JPG_EXTENSION));
            Files.copy(profileImage.getInputStream(), userFolder.resolve(user.getNom() + DOT + JPG_EXTENSION), REPLACE_EXISTING);
            user.setImage(setProfileImageUrl(user.getNom()));
            this.memberDao.save(user);
            LOGGER.info(FILE_SAVED_IN_FILE_SYSTEM + profileImage.getOriginalFilename());
        }
    }
    public Member loadUserByUsername(String username) throws UsernameNotFoundException {
        Member user = findByNom(username);
        if (user == null || user.getId() == null) {
            throw new UsernameNotFoundException("user " + username + " not founded");
        } else {
            return user;
        }
    }

    public Member updateProfileImage(String username, MultipartFile profileImage) throws IOException, NotAnImageFileException {
        Member user = this.loadUserByUsername(username);
        saveProfileImage(user, profileImage);
        return user;
    }

    private String setProfileImageUrl(String username) {
        return ServletUriComponentsBuilder.fromCurrentContextPath().path(USER_IMAGE_PATH + username +
                FORWARD_SLASH + username + DOT + JPG_EXTENSION).toUriString();
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
           prepareMessage(member);
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

package com.example.project1.service;

import com.example.project1.bean.*;
import com.example.project1.dao.ClubsMembersDao;
import com.example.project1.dao.DemandeCreationClbDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemandeCreationClbService {
    @Autowired
    private DemandeCreationClbDao demandeCreationClbDao;
    @Autowired
    private ClubsService clubsService;
    @Autowired
    private SuperAdminDVEService superAdminDVEService;
    @Autowired
    private MemberService memberService;
    @Autowired
    private ClubsMembersService clubsMembersService;
    @Autowired
    private ClubsMembersDao clubsMembersDao;

    @Transactional
    public int deleteDemandeCreationClbById(Long id) {
        return demandeCreationClbDao.deleteDemandeCreationClbById(id);
    }
    @Transactional
    public int deleteByLibelle(String libelle) {
        return demandeCreationClbDao.deleteByLibelle(libelle);
    }

    public List<DemandeCreationClb> findAll() {
        return demandeCreationClbDao.findAll();
    }

    public DemandeCreationClb findByLibelle(String libelle) {
        return demandeCreationClbDao.findByLibelle(libelle);
    }

    public List<DemandeCreationClb> findByCategorie(String categorie) {
        return demandeCreationClbDao.findByCategorie(categorie);
    }

    public DemandeCreationClb findDemandeCreationClbById(Long id) {
        return demandeCreationClbDao.findDemandeCreationClbById(id);
    }

    public int save(DemandeCreationClb demandeCreationClb) {
        if (findDemandeCreationClbById(demandeCreationClb.getId())!= null){
            return -1;
        }else {
            demandeCreationClb.setStatus("inactif");
            demandeCreationClbDao.save(demandeCreationClb);
            return 1;
        }
    }

    public int validate(DemandeCreationClb demandeCreationClb) {
        DemandeCreationClb demande = findByLibelle(demandeCreationClb.getLibelle());
        Member mem= memberService.findMemberById(demandeCreationClb.getMember().getId());
        SuperAdminDVE admin = superAdminDVEService.findByNomAndPrenom(demandeCreationClb.getNomAdmin(),demandeCreationClb.getPrenomAdmin());
        Clubs clb = new Clubs();
        clb.setLibelle(demandeCreationClb.getLibelle());
        clb.setCategorie(demandeCreationClb.getCategorie());
        clb.setDateCreation(demandeCreationClb.getDateCreation());
        clb.setAdmin(admin);
        clb.setStatus("actif");
        clb.setReferentPedagogique(demandeCreationClb.getReferentPedagogique());
        clb.setDescription(demandeCreationClb.getDescription());
        clb.setImage(demandeCreationClb.getImage());
        clubsService.save(clb);
        ClubsMembers clbM = new ClubsMembers();

        clbM.setClubs(clb);
        clbM.setMember(mem);
        clbM.setStatus("Président");
        clbM.setEtat(Boolean.TRUE);
        clbM.setDateAdherence(demandeCreationClb.getDateCreation());
        clubsMembersDao.save(clbM);
        return 1;
    }
}

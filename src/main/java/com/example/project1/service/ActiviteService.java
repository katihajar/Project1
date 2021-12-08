package com.example.project1.service;

import com.example.project1.bean.*;
import com.example.project1.dao.ActiviteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActiviteService {
    @Autowired
    private ActiviteDao activiteDao;
    @Autowired
    private ClubsService clubsService;

    public Activite findByNomActivite(String nomActivite) {
        return activiteDao.findByNomActivite(nomActivite);
    }
    @Transactional
    public int deleteActiviteById(Long id) {
        return activiteDao.deleteActiviteById(id);
    }
    @Transactional
    public int deleteListActiviteById(List<Activite> activite) {
        int res=0;
        for (int i = 0; i < activite.size(); i++) {
            res+=deleteActiviteById(activite.get(i).getId());
        }
        return res;
    }
    public List<Activite> findAll() {
        return activiteDao.findAll();
    }

    public Activite findActiviteById(Long id) {
        return activiteDao.findActiviteById(id);
    }

    public int save(Activite activite) {
        Clubs club= clubsService.findClubsById(activite.getClubs().getId());
        if (findActiviteById(activite.getId())!= null){
            return -1;
        }else{
            activite.setClubs(club);
            activiteDao.save(activite);
            return 1;
        }
    }

    public List<Activite> findByClubsLibelle(String libelle) {
        return activiteDao.findByClubsLibelle(libelle);
    }

    public List<Activite> findByClubsCategorie(String categorie) {
        return activiteDao.findByClubsCategorie(categorie);
    }

    public Activite update(Activite activite) {
        Clubs clubs= clubsService.findClubsById(activite.getClubs().getId());
        Activite acti= findActiviteById(activite.getId());
        acti.setClubs(clubs);
        acti.setNomActivite(activite.getNomActivite());
        acti.setDescription(activite.getDescription());
        acti.setBudget(activite.getBudget());
        acti.setImage(activite.getImage());
        return activiteDao.save(acti);
    }
}

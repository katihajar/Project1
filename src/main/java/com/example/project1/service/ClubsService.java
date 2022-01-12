package com.example.project1.service;

import com.example.project1.bean.Clubs;
import com.example.project1.dao.ActiviteDao;
import com.example.project1.dao.ClubsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClubsService {
    @Autowired
    private ClubsDao clubsDao;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ActiviteService activiteService;
    @Autowired
    private ClubsMembersService clubsMembersService;
    @Autowired
    private DemandeCreationClbService demandeCreationClbService;

    public List<Clubs> findAll() {
        return clubsDao.findAll();
    }
    public List<Clubs> findClubsByIdNotIn(ArrayList<Long>  ids) {
        return clubsDao.findClubsByIdNotIn(ids);
    }
    /*public List<Clubs> clubsNotIn(List<Long> ids) {
        List<Clubs> club= new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            Clubs clubss = findClubsByIdNotIn(ids.get(i));
            club.add(clubss);
        }
        return club;
    }*/
    public List<Clubs> findByCritere(String id) {
        String query = "SELECT a FROM Clubs a WHERE a.id != '" + id + "'";
        return entityManager.createQuery(query).getResultList();
    }
    @Transactional
    public int deleteClubsById(Long id) {
        int res= clubsDao.deleteClubsById(id);
        int res1= clubsMembersService.deleteByClubsId(id);
        int res2= activiteService.deleteByClubsId(id);
        return res+res1+res2;
    }
    @Transactional
    public int deleteListClubsById(List<Clubs> clubs) {
        int res=0;
        for (int i = 0; i < clubs.size(); i++) {
            res+=deleteClubsById(clubs.get(i).getId());
        }
        return res;
    }

    public List<Clubs> findByStatus(String status) {
        return clubsDao.findByStatus(status);
    }

    public Clubs findClubsById(Long id) {
        return clubsDao.findClubsById(id);
    }

    public Clubs findByLibelle(String libelle) {
        return clubsDao.findByLibelle(libelle);
    }

    public List<Clubs> findByCategorie(String categorie) {
        return clubsDao.findByCategorie(categorie);
    }

    public List<Clubs> findByReferentPedagogique(String referentPedagogique) {
        return clubsDao.findByReferentPedagogique(referentPedagogique);
    }
    public int save(Clubs clubs) {
        if (findClubsById(clubs.getId())!= null && findByLibelle(clubs.getLibelle())!=null){
            return -1;
        }else{
            if (demandeCreationClbService.findByLibelle(clubs.getLibelle())!=null){
                demandeCreationClbService.deleteByLibelle(clubs.getLibelle());
            }
            clubsDao.save(clubs);
            return 1;
        }
    }
    public Clubs update(Clubs clubs) {
        clubs.setStatus(clubs.getStatus());
        clubs.setCategorie(clubs.getStatus());
        clubs.setLibelle(clubs.getLibelle());
        clubs.setReferentPedagogique(clubs.getReferentPedagogique());
        return clubsDao.save(clubs);
    }
}

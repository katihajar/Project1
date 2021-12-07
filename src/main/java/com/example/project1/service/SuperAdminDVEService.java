package com.example.project1.service;

import com.example.project1.bean.JuryDVE;
import com.example.project1.bean.SuperAdminDVE;
import com.example.project1.dao.SuperAdminDVEDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class SuperAdminDVEService {
    @Autowired
    private SuperAdminDVEDao superAdminDVEDao;
    @Autowired
    private EntityManager entityManager;

    public Object findByCritere(String login, String password) {
        String query = "SELECT a FROM SuperAdminDVE a WHERE a.login= '" + login + "' and a.password='"+ password + "'";
        return entityManager.createQuery(query).getSingleResult();
    }
    @Transactional
    public int deleteListSuperAdminDVEById(List<SuperAdminDVE> superAdminDVE) {
        int res=0;
        for (int i = 0; i < superAdminDVE.size(); i++) {
            res+=deleteSuperAdminDVEById(superAdminDVE.get(i).getId());
        }
        return res;
    }
    @Transactional
    public int deleteSuperAdminDVEById(Long id) {
        return superAdminDVEDao.deleteSuperAdminDVEById(id);
    }

    public SuperAdminDVE findByNomAndPrenom(String nom, String prenom) {
        return superAdminDVEDao.findByNomAndPrenom(nom, prenom);
    }

    public SuperAdminDVE findSuperAdminDVEById(Long id) {
        return superAdminDVEDao.findSuperAdminDVEById(id);
    }

    public List<SuperAdminDVE> findAll() {
        return superAdminDVEDao.findAll();
    }

    public int save(SuperAdminDVE superAdminDVE) {
        if (findSuperAdminDVEById(superAdminDVE.getId())!= null){
            return -1;
        }else {
            superAdminDVEDao.save(superAdminDVE);
            return 1;
        }
    }
}

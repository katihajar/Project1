package com.example.project1.service;

import com.example.project1.bean.JuryDVE;
import com.example.project1.dao.JuryDVEDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class JuryDVEService {
    @Autowired
    private JuryDVEDao juryDVEDao;
    @Autowired
    private EntityManager entityManager;

    public Object findByCritere(String login, String password) {
        String query = "SELECT a FROM JuryDVE a WHERE a.login= '" + login + "' and a.password='" + password + "'";
        return entityManager.createQuery(query).getSingleResult();
    }
    @Transactional
    public int deleteListJuryDVEById(List<JuryDVE> juryDVE) {
        int res=0;
        for (int i = 0; i < juryDVE.size(); i++) {
            res+=deleteJuryDVEById(juryDVE.get(i).getId());
        }
        return res;
    }

    public JuryDVE findJuryDVEById(Long id) {
        return juryDVEDao.findJuryDVEById(id);
    }

    @Transactional
    public int deleteJuryDVEById(Long id) {
        return juryDVEDao.deleteJuryDVEById(id);
    }

    public JuryDVE findByNomAndPrenom(String nom, String prenom) {
        return juryDVEDao.findByNomAndPrenom(nom, prenom);
    }

    public List<JuryDVE> findAll() {
        return juryDVEDao.findAll();
    }

    public int save(JuryDVE juryDVE) {
        if (findJuryDVEById(juryDVE.getId())!= null){
            return -1;
        }else {
            juryDVEDao.save(juryDVE);
            return 1;
        }
    }
}

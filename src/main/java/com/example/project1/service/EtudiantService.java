package com.example.project1.service;

import com.example.project1.bean.Etudiant;
import com.example.project1.dao.EtudiantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantDao etudiantDao;
    @Transactional
    public int deleteEtudiantById(Long id) {
        return etudiantDao.deleteEtudiantById(id);
    }
    @Transactional
    public int deleteListEtudiantById(List<Etudiant> etudiants) {
        int res=0;
        for (int i = 0; i < etudiants.size(); i++) {
            res+=deleteEtudiantById(etudiants.get(i).getId());
        }
        return res;
    }

    public Etudiant findByNomAndPrenom(String nom, String prenom) {
        return etudiantDao.findByNomAndPrenom(nom, prenom);
    }

    public Etudiant findEtudiantById(Long id) {
        return etudiantDao.findEtudiantById(id);
    }

    public List<Etudiant> findAll() {
        return etudiantDao.findAll();
    }

    public Etudiant findByLogin(String login) {
        return etudiantDao.findByLogin(login);
    }

    public int save(Etudiant etudiant) {
        if (findEtudiantById(etudiant.getId())!= null){
            return -1;
        }else if (findByLogin(etudiant.getLogin()) != null){
            return -2;
        }else{
            etudiantDao.save(etudiant);
            return 1;
        }
    }



}

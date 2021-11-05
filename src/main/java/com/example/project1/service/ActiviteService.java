package com.example.project1.service;

import com.example.project1.bean.Activite;
import com.example.project1.bean.Etudiant;
import com.example.project1.dao.ActiviteDao;
import com.example.project1.dao.EtudiantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActiviteService {
    @Autowired
    private ActiviteDao activiteDao;

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
        if (findActiviteById(activite.getId())!= null){
            return -1;
        }else{
            activiteDao.save(activite);
            return 1;
        }
    }
}

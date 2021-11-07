package com.example.project1.service;

import com.example.project1.bean.Activite;
import com.example.project1.bean.Tresorerie;
import com.example.project1.dao.TresorerieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TresorerieService {
    @Autowired
    private TresorerieDao tresorerieDao;
    @Autowired
    private ActiviteService activiteService;

    public Tresorerie findTresorerieById(Long id) {
        return tresorerieDao.findTresorerieById(id);
    }

    public Tresorerie findByActiviteNomActivite(String nomActivite) {
        return tresorerieDao.findByActiviteNomActivite(nomActivite);
    }

    public Tresorerie findByActiviteId(Long id) {
        return tresorerieDao.findByActiviteId(id);
    }

    @Transactional
    public int deleteListTresorerieById(List<Tresorerie> tresorerie) {
        int res=0;
        for (int i = 0; i < tresorerie.size(); i++) {
            res+=deleteTresorerieById(tresorerie.get(i).getId());
        }
        return res;
    }
    @Transactional
    public int deleteTresorerieById(Long id) {
        return tresorerieDao.deleteTresorerieById(id);
    }

    public List<Tresorerie> findAll() {
        return tresorerieDao.findAll();
    }

    public int save(Tresorerie tresorerie) {
        if (findTresorerieById(tresorerie.getId())!= null){
            return -1;
        }else {
            tresorerieDao.save(tresorerie);
            return 1;
        }
    }
    public Tresorerie update(Tresorerie tresorerie) {
        Activite activite = activiteService.findActiviteById(tresorerie.getActivite().getId());
        tresorerie.setActivite(activite);
        tresorerie.setInn(tresorerie.getInn());
        return tresorerieDao.save(tresorerie);
    }
}

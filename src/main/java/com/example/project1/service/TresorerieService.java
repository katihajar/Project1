package com.example.project1.service;

import com.example.project1.bean.Activite;
import com.example.project1.bean.Tresorerie;
import com.example.project1.dao.ActiviteDao;
import com.example.project1.dao.TresorerieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class TresorerieService {
    @Autowired
    private TresorerieDao tresorerieDao;
    @Autowired
    private ActiviteService activiteService;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private ActiviteDao activiteDao;

    public Tresorerie findTopByOrderByDateTresorerieDesc() {
        return tresorerieDao.findTopByOrderByDateTresorerieDesc();
    }


    public Tresorerie findTresorerieById(Long id) {
        return tresorerieDao.findTresorerieById(id);
    }

    public List<Tresorerie> findByActiviteNomActivite(String nomActivite) {
        return tresorerieDao.findByActiviteNomActivite(nomActivite);
    }

    public Tresorerie findTopByActiviteIdOrderByDateTresorerieDesc(Long id) {
        return tresorerieDao.findTopByActiviteIdOrderByDateTresorerieDesc(id);
    }
    public List<Tresorerie> findByCritere(Long id)
    {
        String query = "SELECT n From Tresorerie n where n.activite.id = '"+id+"'ORDER BY n.dateTresorerie DESC";
        return entityManager.createQuery(query).getResultList();
    }
    public List<Tresorerie> findByActiviteId(Long id) {
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
        Tresorerie tres= findTopByActiviteIdOrderByDateTresorerieDesc(tresorerie.getActivite().getId());
        if (findTresorerieById(tresorerie.getId())!= null){
            return -1;
        }else {
            if (tres == null){
                tresorerie.setAmountBudget(tresorerie.getActivite().getBudget().add(tresorerie.getAmount()));
            }else {
                tresorerie.setAmountBudget(tres.getAmountBudget().add(tresorerie.getAmount()));
            }
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

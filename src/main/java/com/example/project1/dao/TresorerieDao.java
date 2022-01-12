package com.example.project1.dao;
import com.example.project1.bean.Tresorerie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TresorerieDao extends JpaRepository<Tresorerie, Long> {
    Tresorerie findTresorerieById(Long id);
    Tresorerie findTopByOrderByDateTresorerieDesc();
    Tresorerie findTopByActiviteIdOrderByDateTresorerieDesc(Long id);
    List<Tresorerie> findByActiviteNomActivite(String nomActivite);
    List<Tresorerie> findByActiviteId(Long id);
    int deleteTresorerieById(Long id);
}

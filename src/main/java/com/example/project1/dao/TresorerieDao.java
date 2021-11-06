package com.example.project1.dao;
import com.example.project1.bean.Tresorerie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TresorerieDao extends JpaRepository<Tresorerie, Long> {
    Tresorerie findTresorerieById(Long id);
    Tresorerie findByActiviteNomActivite(String nomActivite);
    Tresorerie findByActiviteId(Long id);
    int deleteTresorerieById(Long id);
}

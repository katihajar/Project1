package com.example.project1.rest.admin;

import com.example.project1.bean.Tresorerie;
import com.example.project1.service.TresorerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/tresorerie")
public class TresorerieAdminRest {
    @Autowired
    private TresorerieService tresorerieService;

    @GetMapping("/id/{id}")
    public Tresorerie findTresorerieById(@PathVariable Long id) {
        return tresorerieService.findTresorerieById(id);
    }
    @GetMapping("/nomActivite/{nomActivite}")
    public List<Tresorerie> findByActiviteNomActivite(@PathVariable String nomActivite) {
        return tresorerieService.findByActiviteNomActivite(nomActivite);
    }
    @GetMapping("/activite/id/{id}")
    public List<Tresorerie> findByActiviteId(@PathVariable Long id) {
        return tresorerieService.findByActiviteId(id);
    }

    @DeleteMapping("/delete-multiple")
    public int deleteListTresorerieById(@RequestBody List<Tresorerie> tresorerie) {
        return tresorerieService.deleteListTresorerieById(tresorerie);
    }

    @DeleteMapping("/id/{id}")
    public int deleteTresorerieById(@PathVariable Long id) {
        return tresorerieService.deleteTresorerieById(id);
    }

    @GetMapping("/")
    public List<Tresorerie> findAll() {
        return tresorerieService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody Tresorerie tresorerie) {
        return tresorerieService.save(tresorerie);
    }
    @PutMapping("/")
    public Tresorerie update(@RequestBody Tresorerie tresorerie) {
        return tresorerieService.update(tresorerie);
    }
}

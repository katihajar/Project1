package com.example.project1.rest.jury;

import com.example.project1.bean.Activite;
import com.example.project1.service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/jury/activite")
public class ActiviteJuryRest {
    @GetMapping("/nomActivite/{nomActivite}")
    public Activite findByNomActivite(@PathVariable String nomActivite) {
        return activiteService.findByNomActivite(nomActivite);
    }

    @DeleteMapping("/id/{id}")
    public int deleteActiviteById(@PathVariable  Long id) {
        return activiteService.deleteActiviteById(id);
    }

    @DeleteMapping("/delete-multipl")
    public int deleteListActiviteById(@RequestBody List<Activite> activite) {
        return activiteService.deleteListActiviteById(activite);
    }

    @GetMapping("/")
    public List<Activite> findAll() {
        return activiteService.findAll();
    }
    @GetMapping("/id/{id}")
    public Activite findActiviteById(@PathVariable Long id) {
        return activiteService.findActiviteById(id);
    }

    @PostMapping("/")
    public int save(@RequestBody Activite activite) throws IOException {
        return activiteService.save(activite);
    }
    @GetMapping("/clubs/libelle/{libelle}")
    public List<Activite> findByClubsLibelle(@PathVariable String libelle) {
        return activiteService.findByClubsLibelle(libelle);
    }
    @GetMapping("/activite/libelle/{libelle}")
    public List<Activite> findByCritere(@PathVariable String libelle) {
        return activiteService.findByCritere(libelle);
    }

    @GetMapping("/categorie/{categorie}")
    public List<Activite> findByClubsCategorie(@PathVariable String categorie) {
        return activiteService.findByClubsCategorie(categorie);
    }
    @PutMapping("/")
    public Activite update(@RequestBody Activite activite) {
        return activiteService.update(activite);
    }

    @Autowired
    private ActiviteService activiteService;
}

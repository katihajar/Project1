package com.example.project1.rest.admin;

import com.example.project1.bean.Clubs;
import com.example.project1.service.ClubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/clubs")
public class ClubsAdminRest {
    @Autowired
    private ClubsService clubsService;

    @DeleteMapping("/id/{id}")
    public int deleteClubsById(@PathVariable Long id) {
        return clubsService.deleteClubsById(id);
    }
    @GetMapping("/")
    public List<Clubs> findAll() {
        return clubsService.findAll();
    }

    @DeleteMapping("/delete-Multi")
    public int deleteListClubsById(@RequestBody List<Clubs> clubs) {
        return clubsService.deleteListClubsById(clubs);
    }
    @GetMapping("/id/{id}")
    public Clubs findClubsById(@PathVariable Long id) {
        return clubsService.findClubsById(id);
    }
    @GetMapping("/libelle/{libelle}")
    public Clubs findByLibelle(@PathVariable String libelle) {
        return clubsService.findByLibelle(libelle);
    }
    @GetMapping("/categorie/{categorie}")
    public List<Clubs> findByCategorie(@PathVariable String categorie) {
        return clubsService.findByCategorie(categorie);
    }
    @GetMapping("/referentPedagogique/{referentPedagogique}")
    public List<Clubs> findByReferentPedagogique(@PathVariable String referentPedagogique) {
        return clubsService.findByReferentPedagogique(referentPedagogique);
    }
    @PostMapping("/")
    public int save(@RequestBody Clubs clubs) {
        return clubsService.save(clubs);
    }
    @PutMapping("/")
    public Clubs update(@RequestBody Clubs clubs) {
        return clubsService.update(clubs);
    }
}

package com.example.project1.rest.member;

import com.example.project1.bean.Clubs;
import com.example.project1.bean.ClubsMembers;
import com.example.project1.service.ClubsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member/clubs")
public class ClubsMemberRest {
    @Autowired
    private ClubsService clubsService;
    @PostMapping("/clubs/")
    public List<Clubs> findClubsByClubsMembersClubsNotIn(@RequestBody List<ClubsMembers> clubsMembers) {
        return clubsService.findClubsByClubsMembersClubsNotIn(clubsMembers);
    }

    @GetMapping("/clubs/id/{id}")
    public List<Clubs> findByCritere(@PathVariable String id) {
        return clubsService.findByCritere(id);
    }

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

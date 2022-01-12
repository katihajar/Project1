package com.example.project1.rest.member;

import com.example.project1.bean.ClubsMembers;
import com.example.project1.service.ClubsMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member/clubsmembers")
public class ClubsMembersMembersRest {
    @Autowired
    private ClubsMembersService clubsMembersService;
    @GetMapping("/member/id/{id}")
    public List<ClubsMembers> findByMemberId(@PathVariable Long id) {
        return clubsMembersService.findByMemberId(id);
    }
    @GetMapping("/member/id/{id}/etat/{etat}")
    public List<ClubsMembers> findByMemberIdAndEtat(@PathVariable Long id,@PathVariable Boolean etat) {
        return clubsMembersService.findByMemberIdAndEtat(id, etat);
    }
    @GetMapping("/clubs/id/{id}")
    public List<Long> findByCritere(@PathVariable Long id) {
        return clubsMembersService.findByCritere(id);
    }
    @PostMapping("/clubsM/{etat}")
    public List<ClubsMembers> findClubsMembersByClubsIdNotIn(@RequestBody ArrayList<Long> ids, @PathVariable boolean etat) {
        return clubsMembersService.findClubsMembersByClubsIdNotInAndEtat(ids, etat);
    }

    @GetMapping("/member/id/{id}/etat/{etat}/status/{status}")
    public List<ClubsMembers> findByMemberIdAndEtatAndClubsStatus(@PathVariable Long id,@PathVariable Boolean etat,@PathVariable String status) {
        return clubsMembersService.findByMemberIdAndEtatAndClubsStatus(id, etat, status);
    }

    @GetMapping("/id/{id}")
    public ClubsMembers findClubsMembersById(@PathVariable Long id) {
        return clubsMembersService.findClubsMembersById(id);
    }

    @DeleteMapping("/delete-Multi")
    public int deleteListClubsActiviteById(@RequestBody List<ClubsMembers> clubsMembers) {
        return clubsMembersService.deleteListClubsActiviteById(clubsMembers);
    }
    @GetMapping("/etat/{etat}")
    public List<ClubsMembers> findByEtat(@PathVariable Boolean etat) {
        return clubsMembersService.findByEtat(etat);
    }

    @GetMapping("/libelle/{libelle}/etat/{etat}/status/{status}")
    public List<ClubsMembers> findByClubsLibelleAndEtatAndClubsStatus(@PathVariable String libelle,@PathVariable Boolean etat, @PathVariable String status) {
        return clubsMembersService.findByClubsLibelleAndEtatAndClubsStatus(libelle, etat, status);
    }

    @DeleteMapping("/id/{id}")
    public int deleteClubsActiviteById(@PathVariable Long id) {
        return clubsMembersService.deleteClubsActiviteById(id);
    }
    @GetMapping("/libelle/{libelle}")
    public List<ClubsMembers> findByClubsLibelle(@PathVariable String libelle) {
        return clubsMembersService.findByClubsLibelle(libelle);
    }
    @GetMapping("/numeroEtudiant/{numeroEtudiant}")
    public List<ClubsMembers> findByMemberNumeroEtudiant(String numeroEtudiant) {
        return clubsMembersService.findByMemberNumeroEtudiant(numeroEtudiant);
    }
    @GetMapping("/")
    public List<ClubsMembers> findAll() {
        return clubsMembersService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody ClubsMembers clubsMembers) {
        return clubsMembersService.save(clubsMembers);
    }
    @PutMapping("/")
    public ClubsMembers update(@RequestBody ClubsMembers clubsMembers) {
        return clubsMembersService.update(clubsMembers);
    }
}

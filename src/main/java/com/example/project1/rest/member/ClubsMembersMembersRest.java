package com.example.project1.rest.member;

import com.example.project1.bean.ClubsMembers;
import com.example.project1.service.ClubsMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/libelle/{libelle}/etat/{etat}")
    public List<ClubsMembers> findByClubsLibelleAndEtat(@PathVariable String libelle,@PathVariable Boolean etat) {
        return clubsMembersService.findByClubsLibelleAndEtat(libelle, etat);
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
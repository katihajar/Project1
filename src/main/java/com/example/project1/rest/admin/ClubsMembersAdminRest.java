package com.example.project1.rest.admin;

import com.example.project1.bean.ClubsMembers;
import com.example.project1.service.ClubsMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/clubsmembers")
public class ClubsMembersAdminRest {
    @Autowired
    private ClubsMembersService clubsMembersService;

    @GetMapping("/id/{id}")
    public ClubsMembers findClubsMembersById(@PathVariable Long id) {
        return clubsMembersService.findClubsMembersById(id);
    }

    @DeleteMapping("/delete-Multi")
    public int deleteListClubsActiviteById(@RequestBody List<ClubsMembers> clubsMembers) {
        return clubsMembersService.deleteListClubsActiviteById(clubsMembers);
    }
    @GetMapping("/libelle/{libelle}/etat/{etat}/status/{status}")
    public List<ClubsMembers> findByClubsLibelleAndEtat(@PathVariable String libelle,@PathVariable Boolean etat, @PathVariable String status) {
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

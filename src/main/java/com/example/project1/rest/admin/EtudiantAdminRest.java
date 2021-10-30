package com.example.project1.rest.admin;

import com.example.project1.bean.Etudiant;
import com.example.project1.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/etudiant")
public class EtudiantAdminRest {
    @Autowired
    private EtudiantService etudiantService;
    @DeleteMapping("/id/{id}")
    public int deleteEtudiantById(@PathVariable Long id) {
        return etudiantService.deleteEtudiantById(id);
    }
    @DeleteMapping("/delete-multiple-by-id")
    public int deleteListEtudiantById(@PathVariable List<Etudiant> etudiants) {
        return etudiantService.deleteListEtudiantById(etudiants);
    }
    @GetMapping("/nom/{nom}/prenom/{prenom}")
    public Etudiant findByNomAndPrenom(@PathVariable String nom,@PathVariable String prenom) {
        return etudiantService.findByNomAndPrenom(nom, prenom);
    }
    @GetMapping("/etudiant/id/{id}")
    public Etudiant findEtudiantById(@PathVariable Long id) {
        return etudiantService.findEtudiantById(id);
    }
    @GetMapping("/")
    public List<Etudiant> findAll() {
        return etudiantService.findAll();
    }
    @GetMapping("/login/{login}")
    public Etudiant findByLogin(@PathVariable String login) {
        return etudiantService.findByLogin(login);
    }
    @PostMapping("/")
    public int save(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }



}

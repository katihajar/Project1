package com.example.project1.rest.admin;

import com.example.project1.bean.DemandeCreationClb;
import com.example.project1.service.DemandeCreationClbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/demandecreationclb")
public class DemandeCreationClbAdminRest {
    @Autowired
    private DemandeCreationClbService demandeCreationClbService;

    public int deleteDemandeCreationClbById(Long id) {
        return demandeCreationClbService.deleteDemandeCreationClbById(id);
    }
    @GetMapping("/")
    public List<DemandeCreationClb> findAll() {
        return demandeCreationClbService.findAll();
    }

    public DemandeCreationClb findByLibelle(String libelle) {
        return demandeCreationClbService.findByLibelle(libelle);
    }

    public List<DemandeCreationClb> findByCategorie(String categorie) {
        return demandeCreationClbService.findByCategorie(categorie);
    }

    public DemandeCreationClb findDemandeCreationClbById(Long id) {
        return demandeCreationClbService.findDemandeCreationClbById(id);
    }
    @PostMapping("/")
    public int save(@RequestBody DemandeCreationClb demandeCreationClb) {
        return demandeCreationClbService.save(demandeCreationClb);
    }
    @PutMapping("/")
    public int validate(@RequestBody DemandeCreationClb demandeCreationClb) {
        return demandeCreationClbService.validate(demandeCreationClb);
    }
}

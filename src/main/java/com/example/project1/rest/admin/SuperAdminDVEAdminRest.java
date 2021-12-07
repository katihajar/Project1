package com.example.project1.rest.admin;

import com.example.project1.bean.SuperAdminDVE;
import com.example.project1.service.SuperAdminDVEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/superadmin")
public class SuperAdminDVEAdminRest {
    @Autowired
    private SuperAdminDVEService superAdminDVEService;

    @DeleteMapping("/delete-multiple")
    public int deleteListSuperAdminDVEById(@RequestBody List<SuperAdminDVE> superAdminDVE) {
        return superAdminDVEService.deleteListSuperAdminDVEById(superAdminDVE);
    }

    @DeleteMapping("/id/{id}")
    public int deleteSuperAdminDVEById(@PathVariable Long id) {
        return superAdminDVEService.deleteSuperAdminDVEById(id);
    }

    @GetMapping("/nom/{nom}/prenom/{prenom}")
    public SuperAdminDVE findByNomAndPrenom(@PathVariable String nom,@PathVariable String prenom) {
        return superAdminDVEService.findByNomAndPrenom(nom, prenom);
    }
    @GetMapping("/id/{id}")
    public SuperAdminDVE findSuperAdminDVEById(@PathVariable Long id) {
        return superAdminDVEService.findSuperAdminDVEById(id);
    }
    @GetMapping("/")
    public List<SuperAdminDVE> findAll() {
        return superAdminDVEService.findAll();
    }
    @GetMapping("/login/{login}/password/{password}")
    public Object findByCritere(@PathVariable String login,@PathVariable String password) {
        return superAdminDVEService.findByCritere(login, password);
    }

    @PostMapping("/")
    public int save(@RequestBody SuperAdminDVE superAdminDVE) {
        return superAdminDVEService.save(superAdminDVE);
    }
}

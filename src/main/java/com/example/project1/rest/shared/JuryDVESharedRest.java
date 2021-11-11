package com.example.project1.rest.shared;

import com.example.project1.bean.JuryDVE;
import com.example.project1.service.JuryDVEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shared/jury")
public class JuryDVESharedRest {
    @Autowired
    private JuryDVEService juryDVEService;

    @DeleteMapping("/multiple-delete")
    public int deleteListJuryDVEById(@RequestBody List<JuryDVE> juryDVE) {
        return juryDVEService.deleteListJuryDVEById(juryDVE);
    }
    @GetMapping("/id/{id}")
    public JuryDVE findJuryDVEById(@PathVariable Long id) {
        return juryDVEService.findJuryDVEById(id);
    }

    @DeleteMapping("/id/{id}")
    public int deleteJuryDVEById(@PathVariable Long id) {
        return juryDVEService.deleteJuryDVEById(id);
    }
    @GetMapping("/nom/{nom}/prenom/{prenom}")
    public JuryDVE findByNomAndPrenom(@PathVariable String nom,@PathVariable String prenom) {
        return juryDVEService.findByNomAndPrenom(nom, prenom);
    }
    @GetMapping("/")
    public List<JuryDVE> findAll() {
        return juryDVEService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody JuryDVE juryDVE) {
        return juryDVEService.save(juryDVE);
    }
}

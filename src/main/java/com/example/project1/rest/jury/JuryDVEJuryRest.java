package com.example.project1.rest.jury;

import com.example.project1.bean.JuryDVE;
import com.example.project1.service.JuryDVEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jury/jury")
public class JuryDVEJuryRest {
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
    @GetMapping("/login/{login}/password/{password}")
    public Object findByCritere(@PathVariable String login,@PathVariable String password) {
        return juryDVEService.findByCritere(login, password);
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

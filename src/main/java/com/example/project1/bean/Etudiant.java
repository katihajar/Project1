package com.example.project1.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Etudiant  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String numeroEtudiant;
    private String niveau;
    private String fillier;
    private String login;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumeroEtudiant() {
        return numeroEtudiant;
    }

    public void setNumeroEtudiant(String numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getFillier() {
        return fillier;
    }

    public void setFillier(String fillier) {
        this.fillier = fillier;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
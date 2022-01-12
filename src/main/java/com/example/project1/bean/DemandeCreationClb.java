package com.example.project1.bean;

import javax.persistence.*;
import java.util.Date;
@Entity
public class DemandeCreationClb {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String referentPedagogique;
    private String status;
    private String categorie;
    @Temporal(TemporalType.DATE)
    private Date dateCreation ;
    private String image;
    private String description;
    private String nomAdmin;
    private String prenomAdmin;
    @OneToOne
    private Member member;

    public String getNomAdmin() {
        return nomAdmin;
    }

    public String getPrenomAdmin() {
        return prenomAdmin;
    }

    public void setPrenomAdmin(String prenomAdmin) {
        this.prenomAdmin = prenomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getReferentPedagogique() {
        return referentPedagogique;
    }

    public void setReferentPedagogique(String referentPedagogique) {
        this.referentPedagogique = referentPedagogique;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

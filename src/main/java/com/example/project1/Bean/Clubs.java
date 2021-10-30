package com.example.project1.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Clubs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libelle;
    private String referentPedagogique;
    private String status;
    private String categorie;
    @Temporal(TemporalType.DATE)
    private Date dateCreation ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "clubs")
    private List<Member> members ;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "clubs")
    private List<Activite> activites ;
    @ManyToOne
    private JuryDVE jury;
    @ManyToOne
    private SuperAdminDVE admin;

    public SuperAdminDVE getAdmin() {
        return admin;
    }

    public List<Activite> getActivites() {
        return activites;
    }

    public void setActivites(List<Activite> activites) {
        this.activites = activites;
    }

    public void setAdmin(SuperAdminDVE admin) {
        this.admin = admin;
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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public JuryDVE getJury() {
        return jury;
    }

    public void setJury(JuryDVE jury) {
        this.jury = jury;
    }
}

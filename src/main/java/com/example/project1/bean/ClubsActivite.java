package com.example.project1.bean;

import javax.persistence.*;

@Entity
public class ClubsActivite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Clubs clubs;
    @ManyToOne
    private Activite activite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clubs getClubs() {
        return clubs;
    }

    public void setClubs(Clubs clubs) {
        this.clubs = clubs;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }
}

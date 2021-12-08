package com.example.project1.bean;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ClubsMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateAdherence ;
    private String status ;
    private Boolean etat ;
    @ManyToOne
    private Clubs clubs;
    @ManyToOne
    private Member member;

    public Boolean getEtat() {
        return etat;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Date getDateAdherence() {
        return dateAdherence;
    }

    public void setDateAdherence(Date dateAdherence) {
        this.dateAdherence = dateAdherence;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

package com.example.project1.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ClubsMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date dateAdherence ;
    private String Status ;
    @ManyToOne
    private Clubs clubs;
    @ManyToOne
    private Member member;

    public Date getDateAdherence() {
        return dateAdherence;
    }

    public void setDateAdherence(Date dateAdherence) {
        this.dateAdherence = dateAdherence;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
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

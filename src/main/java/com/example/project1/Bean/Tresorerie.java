package com.example.project1.Bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Tresorerie  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String budget;
    private String Transaction;
    private String depot;
    @Temporal(TemporalType.DATE)
    private Date date ;
    @OneToOne
    private ComiteExecutive comite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getTransaction() {
        return Transaction;
    }

    public void setTransaction(String transaction) {
        Transaction = transaction;
    }

    public String getDepot() {
        return depot;
    }

    public void setDepot(String depot) {
        this.depot = depot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ComiteExecutive getComite() {
        return comite;
    }

    public void setComite(ComiteExecutive comite) {
        this.comite = comite;
    }
}
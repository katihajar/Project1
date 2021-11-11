package com.example.project1.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Entity
public class Tresorerie  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean inn;
    private BigDecimal amount;
    @Temporal(TemporalType.DATE)
    private Date dateTresorerie ;
    @OneToOne
    private Activite activite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getInn() {
        return inn;
    }

    public void setInn(Boolean inn) {
        this.inn = inn;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public Date getDateTresorerie() {
        return dateTresorerie;
    }

    public void setDateTresorerie(Date dateTresorerie) {
        this.dateTresorerie = dateTresorerie;
    }
}
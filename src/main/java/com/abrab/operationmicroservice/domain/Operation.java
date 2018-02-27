package com.abrab.operationmicroservice.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rib;
    private Double montant;
    private int type;//debit:0 ,  credit:1
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;

    public Operation() {
    }

    public Operation(String rib, Double montant, int type, Date dateCreation) {
        this.rib = rib;
        this.montant = montant;
        this.type = type;
        this.dateCreation = dateCreation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRib() {
        return rib;
    }

    public void setRib(String rib) {
        this.rib = rib;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation = (Operation) o;
        return Objects.equals(id, operation.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }


    @Override
    public String toString() {
        return "Operation{" +
                "rib='" + rib + '\'' +
                ", montant=" + montant +
                ", type=" + type +
                ", dateCreation=" + dateCreation +
                '}';
    }
}

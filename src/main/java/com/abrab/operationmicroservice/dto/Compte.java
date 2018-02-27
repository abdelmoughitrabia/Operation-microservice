package com.abrab.operationmicroservice.dto;

import java.util.Date;

public class Compte {

    private Long id;
    private String Rib;
    private Double solde;
    private String cin;
    private Date dateCreation;
    private String port;

    public Compte() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getRib() {
        return Rib;
    }

    public void setRib(String rib) {
        Rib = rib;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}

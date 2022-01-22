/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class RendezVous {
    private int id;
    protected Date date;
    protected String libelle;
    


    public Secretaire getSecretaire() {
        return secretaire;
    }

    public void setSecretaire(Secretaire secretaire) {
        this.secretaire = secretaire;
    }

    public RendezVous(int id, Date date, String libelle, Secretaire secretaire, Patient patient) {
        this.id = id;
        this.date = date;
        this.libelle = libelle;
        this.secretaire = secretaire;
        this.patient = patient;
    }

    public RendezVous(Date date, String libelle, Secretaire secretaire, Patient patient) {
        this.date = date;
        this.libelle = libelle;
        this.secretaire = secretaire;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    
    //attribut navigationnel
    private Secretaire secretaire;
    private Patient patient;

    public RendezVous() {
    }

    public RendezVous(int id) {
        this.id = id;
    }

    public RendezVous(Date date, String libelle) {
        this.date = date;
        this.libelle = libelle;
    }

    public RendezVous(int id, Date date, String libelle) {
        this.id = id;
        this.date = date;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
      
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class Consultation extends RendezVous{
    private int id;
    private Date date;
   

    public Consultation(int id, Date date, Ordenance ordenance) {
        this.id = id;
        this.date = date;
        this.ordenance = ordenance;
    }

    
    //attribut navigationnel
    private Medecin medecin;
    private Ordenance ordenance;


    
    public Consultation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Consultation(int id, Date date, Medecin medecin, Ordenance ordenance) {
        this.id = id;
        this.date = date;
        this.medecin = medecin;
        this.ordenance = ordenance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Ordenance getOrdenance() {
        return ordenance;
    }

    public void setOrdenance(Ordenance ordenance) {
        this.ordenance = ordenance;
    }

    
    
}

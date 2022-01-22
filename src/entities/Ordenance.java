/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class Ordenance {
    private int id;
    private Consultation consultation;
    private List<Medicament> medicament;
    
    public Ordenance(){
    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ordenance(int id) {
        this.id = id;
    }
    
}

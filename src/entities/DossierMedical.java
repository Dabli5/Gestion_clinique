/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class DossierMedical {
    private int id;
    
    //attribut navigationnel
    private Patient patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DossierMedical() {
    }

    public DossierMedical(int id) {
        this.id = id;
    }
    
}

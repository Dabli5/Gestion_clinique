/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class Prestation extends RendezVous{

    private int codeprestation;
    private String typePresta;
    
    
    //attribut navigationnel
    private  ResponsablePrestation responsablePrestation; 
    
    public Prestation() {
    }

    public Prestation(int codeprestation, String typePresta ,Date date) {
        super(date, typePresta);
        this.codeprestation = codeprestation;
    }

    public Prestation( int codeprestation, int id, Date date, String typePresta) {
        super(id, date, typePresta);
        this.codeprestation = codeprestation;
    }

    public Prestation(int codeprestation, String typePresta) {
        this.codeprestation = codeprestation;
        this.typePresta = typePresta;
    }

    public ResponsablePrestation getResponsablePrestation() {
        return responsablePrestation;
    }

    public void setResponsablePrestation(ResponsablePrestation responsablePrestation) {
        this.responsablePrestation = responsablePrestation;
    }



    public int getCodeprestation() {
        return codeprestation;
    }

    public void setCodeprestation(int codeprestation) {
        this.codeprestation = codeprestation;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }
    
    
}

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
public class Medecin extends User{
    private String statut;
    private final String ROLE="ROLE_MEDECIN";
    
    //attribut navigationnel
    private List<Consultation> consultation;

    public Medecin(){
    }

    public Medecin(String statut, int id, String nom, String prenom, String login, String password, String role) {
        super(id, nom, prenom, login, password, role);
        this.statut = statut;
    }

    public Medecin(String statut, String nom, String prenom) {
        super(nom, prenom);
        this.statut = statut;
    }

    public Medecin(String statut, int id, String nom, String prenom) {
        super(id, nom, prenom);
        this.statut = statut;
    }
    
        public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
    
    
}

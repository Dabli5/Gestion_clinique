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
public class Secretaire extends User{
    private final String ROLE="ROLE_SECRETAIRE";
    
    //attribut Navigationnel
    private List<RendezVous> rendezVous;
    

    
    public Secretaire() {
    }

    public Secretaire(int id, String nom, String prenom, String login, String password, String role) {
        super(id, nom, prenom, login, password, role);
        this.role=ROLE;
    }

    public Secretaire(int id, String nom, String prenom) {
        super(id, nom, prenom);
        this.role=ROLE;
    }

    public Secretaire(String nom, String prenom) {
        super(nom, prenom);
        this.role=ROLE;
    }




    
    
    
}

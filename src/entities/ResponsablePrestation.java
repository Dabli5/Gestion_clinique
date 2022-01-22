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
public class ResponsablePrestation extends User {
    private final String ROLE="ROLE_SECRETAIRE";
    
    //attribut navigationnel
    private List<Prestation> prestation;
    
    public ResponsablePrestation(){
    }

    public ResponsablePrestation(String nom, String prenom) {
        super(nom, prenom);
        this.role = ROLE;
    }

    public ResponsablePrestation(int id, String nom, String prenom, String login, String password, String role) {
        super(id, nom, prenom, login, password, role);
        this.role = ROLE;
    }

    
    
}

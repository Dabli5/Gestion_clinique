/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import static java.util.Collections.list;
import java.util.List;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class Patient extends User {
    /*
    public Patient(String code) {
        this.code = code;
    }
    */
    private String antecedantMedical;
    private String code;
    private final String ROLE="ROLE_PATIENT";
   
    //attribut navigationnel
    private List<RendezVous> rendezVous;
    private List<Ordenance> ordenance;
    private DossierMedical dossierMedical;

    
    public Patient(){
    //super();
        this.role=ROLE;
    }  

    public Patient(String antecedantMedical, int id, String nom, String prenom, String login, String password, String role) {
        super(id, nom, prenom, login, password, role);
        this.role = ROLE;
        this.antecedantMedical = antecedantMedical;
    }

    public Patient(String antecedantMedical, int id, String nom, String prenom) {
        super(id, nom, prenom);
        this.role = ROLE;
        this.antecedantMedical = antecedantMedical;
    }

    public Patient(int aInt, String string, String string0, String string1, String string2, String string3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public String getAntecedantMedical() {
        return antecedantMedical;
    }

    public void setAntecedantMedical(String antecedantMedical) {
        this.antecedantMedical = antecedantMedical;
    }
    
    public String getCode() {
        return code;
    }
    public void setCode(String code){
        this.code=code;
    }
    

    
}

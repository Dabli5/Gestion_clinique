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
public class Medicament {
    private int id;
    private int code;
    private String nom;
    private String posologie;
    
    //attribut navigationnel
    private Ordenance ordenance;

    
    public Medicament(int code, String nom, String posologie) {
        this.code = code;
        this.nom = nom;
        this.posologie = posologie;
    }

    public Medicament() {
    }

    public Medicament(int id, int code, String nom, String posologie) {
        this.id = id;
        this.code = code;
        this.nom = nom;
        this.posologie = posologie;
    }
    
    
    public Medicament(String nom, String posologie) {
        this.nom = nom;
        this.posologie = posologie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }
    
}

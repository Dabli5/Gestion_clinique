/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Medecin;
import entities.RendezVous;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class ConsultationDao implements IDao<Consultation>{
    private final DataBase database = new DataBase();
private final String SQL_INSERT="INSERT INTO rendez_vous "
            + "(`date`,`libelle`,`id_patient`)"
            + "VALUES(?,?,?)";
     private final String SQL_SELECT_RV_VALIDER = "SELECT * FROM `rendez_vous` WHERE id_patient=? and libelle=?";
    private final String SQL_SELECT="";

    @Override
    public int insert(Consultation cons) {
        
        int id=0;
        database.openConnexion();
        //chargement de la base de donnee et des requetes
        database.initPrepareStatement(SQL_INSERT);
        try {
            database.getPs().setDate(1, (Date) cons.getDate());
            database.getPs().setString(2, cons.getLibelle());
            database.getPs().setInt(3, cons.getPatient().getId());
            database.executeUpdate(SQL_INSERT);
            ResultSet rs= database.getPs().getGeneratedKeys();
            if(rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultationDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();
        }
        
        return id;
    }
    
    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consultation findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Consultation ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public List<Consultation> findAllRvValiderPConsul(int id){
        List<Consultation> rvmeds = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_RV_VALIDER);
        try {
            database.getPs().setInt(1,id);
            database.getPs().setString(2, "Consultation");
            ResultSet rs = database.executeSelect(SQL_SELECT_RV_VALIDER);
            while(rs.next()){
                if(rs.getInt("id_medecin")!=0){
                    Consultation rvmed = new Consultation();
                    rvmed.setId(rs.getInt("id_rendez_vous"));
                    rvmed.setDate(rs.getDate("date"));
                    rvmed.setLibelle(rs.getString("libelle"));
                    int idmed= rs.getInt("id_medecin");
                    MedecinDao med = new MedecinDao();
                    Medecin  medecin = med.findById(idmed);
                    rvmed.setMedecin(medecin);
                    rvmeds.add(rvmed);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return rvmeds;
    }
          public List<Consultation> findAllRvValiderPConsul1(int id){
        List<Consultation> rvmeds = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_RV_VALIDER);
        try {
            database.getPs().setInt(1,id);
            database.getPs().setString(2, "Consultation");
            ResultSet rs = database.executeSelect(SQL_SELECT_RV_VALIDER);
            while(rs.next()){
                if(rs.getInt("id_medecin")!=0){
                    Consultation rvmed = new Consultation();
                    rvmed.setId(rs.getInt("id_rendez_vous"));
                    rvmed.setDate(rs.getDate("date"));
                    rvmed.setLibelle(rs.getString("libelle"));
                    int idmed= rs.getInt("id_medecin");
                    MedecinDao med = new MedecinDao();
                    Medecin  medecin = med.findById(idmed);
                    rvmed.setMedecin(medecin);
                    rvmeds.add(rvmed);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return rvmeds;
    }
    
    
}

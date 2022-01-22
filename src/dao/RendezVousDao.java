/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entities.Patient;
import entities.RendezVous;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class RendezVousDao implements IDao<RendezVous>{
    private final DataBase database= new DataBase();
    private final String  SQL_SELECT = "SELECT * FROM rendez_vous  "
            + "WHERE libelle like ? ";
    
    private final String SQL_INSERT = "INSERT INTO rendez_vous"
            + "(`date`,`heure`,`libelle`,`id_patient`)"
            + "VALUES(?,?,?)";
    private final String SQL_SELECT_PATIENT_BY_ID = "SELECT * FROM `rendez_vous`"
            + "WHERE id_patient=?";
    private final String SQL_SELECT_MEDECIN_BY_ID = "SELECT * FROM `rendez_vous`"
            + "WHERE id_medecin=?  ";
   
    private final String SQL_UPDATE_RV="UPDATE `rendez_vous` SET `libelle`=? WHERE `id_rendez_vous`= ?";
    private final String SQL_UPDATE_CONS="UPDATE `rendez_vous` SET `id_medecin`=? WHERE id_rendez_vous=?";
    private final String SQL_UPDATE_PRESTA="UPDATE `rendez_vous` SET `id_medecin`=? WHERE id_rendez_vous=?";
    private final String SQL_DELETE="DELETE from `rendez_vous` where id_rendez_vous=?";

    @Override
    public int insert(RendezVous rdv) {
        int id=0;
        database.openConnexion();
        database.initPrepareStatement(SQL_INSERT);
        
        try {
            database.getPs().setDate(1, (java.sql.Date) rdv.getDate());
            //database.getPs().setTime(2, rdv.getHeure());
            database.getPs().setString(2, rdv.getLibelle());
            database.getPs().setInt(3, rdv.getPatient().getId());
            database.executeUpdate(SQL_INSERT);
            ResultSet rs = database.getPs().getGeneratedKeys();
            if(rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        database.closeConnexion();
        return id;
    }
    

    @Override
    public int update(RendezVous rdv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int updateToCons(RendezVous rdv, int id) {
        int nbrLigne=0;
        database.openConnexion();
        database.initPrepareStatement(SQL_UPDATE_CONS);
        try {
            database.getPs().setInt(1, id);
            database.getPs().setInt(2,rdv.getId());
            nbrLigne=database.executeUpdate(SQL_UPDATE_CONS);         
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnexion();
        return nbrLigne;
    }
    
    public int updateToPresta(RendezVous rdv, int id) {
        int nbrLigne=0;
        database.openConnexion();
        database.initPrepareStatement(SQL_UPDATE_PRESTA);
        try {
            database.getPs().setInt(1, id);
            database.getPs().setInt(2,rdv.getId());
            nbrLigne=database.executeUpdate(SQL_UPDATE_PRESTA);         
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnexion();
        return nbrLigne;
    }

    @Override
    public int delete(int id) {
        int nbrLigne=0;
        database.openConnexion();
        database.initPrepareStatement(SQL_DELETE);
        try {
            database.getPs().setInt(1, id);
            nbrLigne=database.executeUpdate(SQL_DELETE);
            
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnexion();
        return nbrLigne;
    }

    @Override
    public List findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RendezVous findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public List<RendezVous> findAllByIdMed(int id) {
        List<RendezVous> rvmeds = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_MEDECIN_BY_ID);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_SELECT_MEDECIN_BY_ID);
            //ResultSet rs2 = database.executeSelect(SQL_SELECT_PATIENT_BY_ID);
            while(rs.next()){
                if(rs.getInt("id_medecin")!=0 && rs.getInt("id_patient")!=0){
                    RendezVous rvmed = new RendezVous();
                    rvmed.setId(rs.getInt("id_rendez_vous"));
                    rvmed.setDate(rs.getDate("date"));
                    rvmed.setLibelle(rs.getString("libelle"));
                    int idpat= rs.getInt("id_patient");
                    PatientDao pat = new PatientDao();
                    Patient  patient = pat.findById(idpat);
                    rvmed.setPatient(patient);
                    rvmeds.add(rvmed);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return rvmeds;
    }
    
    public List<RendezVous> findAllById(int id) {
        List<RendezVous> rvs = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_PATIENT_BY_ID);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_SELECT_PATIENT_BY_ID);
            while(rs.next()){
                if(rs.getInt("id_medecin")==0 && rs.getInt("id_responsable")==0){
                    RendezVous rv = new RendezVous();
                    rv.setId(rs.getInt("id_rendez_vous"));
                    rv.setDate(rs.getDate("date"));
                    rv.setLibelle(rs.getString("libelle"));
                    rvs.add(rv);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return rvs;
    }
        
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Prestation;
import entities.RendezVous;
import entities.ResponsablePrestation;
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
public class PrestationDao implements IDao<Prestation>{
    private final DataBase database= new DataBase();
    
    private final String SQL_SELECT_ALL="SELECT * FROM user "
            + "WHERE role LIKE 'ROLE_RESPONSABLE_PRESTATION'";
    
    private final String SQL_SELECT_BY_ID="SELECT * FROM user "
            + "WHERE role LIKE 'ROLE_RESPONSABLE_PRESTATION' AND id=?";
    
    private final String SQL_INSERT="INSERT INTO rendez_vous "
            + "(`date`,`libelle`,`typePresta`,`id_patient`)"
            + "VALUES(?,?,?,?)";
  private final String SQL_SELECT_RV_VALIDER = "SELECT * FROM `rendez_vous` WHERE id_patient=? and libelle=?";
    @Override
    public int insert(Prestation pres) {
        int id=0;
        database.openConnexion();
        //chargement de la base de donnee et des requetes
        database.initPrepareStatement(SQL_INSERT);
        try {
            database.getPs().setDate(1, (Date) pres.getDate());
            database.getPs().setString(3,pres.getTypePresta());
            database.getPs().setString(2, pres.getLibelle());
            database.getPs().setInt(4, pres.getPatient().getId());
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
    public int update(Prestation ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Prestation> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Prestation findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 public List<Prestation> findAllRvValiderPPresta(int id){
        List<Prestation> rvmeds = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_RV_VALIDER);
        try {
            database.getPs().setInt(1,id);
            database.getPs().setString(2, "Prestation");
            ResultSet rs = database.executeSelect(SQL_SELECT_RV_VALIDER);
            while(rs.next()){
                if(rs.getInt("id_responsable")!=0){
                    Prestation rvmed = new Prestation();
                    rvmed.setId(rs.getInt("id_rendez_vous"));
                    rvmed.setDate(rs.getDate("date"));
                    rvmed.setLibelle(rs.getString("libelle"));
                    int idrep= rs.getInt("id_responsable");
                    System.out.println(idrep);
                    ResponsablePrestationDao rep = new ResponsablePrestationDao();
                    ResponsablePrestation responsable = rep.findById(idrep);
                     System.out.println(responsable);
                    rvmed.setResponsablePrestation(responsable);
                    rvmeds.add(rvmed);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return rvmeds;
    }
       
    
}

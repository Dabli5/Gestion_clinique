/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.RendezVous;
import entities.Secretaire;
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
public class SecretaireDao implements IDao<Secretaire>{
    private final DataBase database= new DataBase();
    RendezVous rdv = new RendezVous();
    private final String SQL_SELECT_ALL="SELECT * FROM user WHERE role LIKE 'ROLE_SECRETAIRE'";
    private final String SQL_SELECT_BY_ID="SELECT * FROM user WHERE role LIKE 'ROLE_SECRETAIRE AND id=?";
    private final String SQL_INSERT="";
   
    private final String SQL_SELECT_ALL_SEC="SELECT * FROM user WHERE role LIKE 'ROLE_PATIENT'";

    private final String SQL_SELECT_BY_ID_SEC="SELECT * FROM `rendez_vous`";

    @Override
    public int insert(Secretaire ogj) {
        int id=0;
        database.openConnexion();
        database.initPrepareStatement(SQL_INSERT);
        
        try {
            database.getPs().setDate(1, (java.sql.Date) rdv.getDate());
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
    public int update(Secretaire ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Secretaire> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<RendezVous> findAllBy() {
        List<RendezVous> rvs = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_BY_ID_SEC);
        try {
            ResultSet rs = database.executeSelect(SQL_SELECT_BY_ID_SEC);
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

    @Override
    public Secretaire findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

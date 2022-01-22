/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Medecin;
import entities.RendezVous;
import entities.ResponsablePrestation;
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
public class ResponsablePrestationDao implements IDao<ResponsablePrestation>{
    private final DataBase database= new DataBase();
    RendezVous rdv = new RendezVous();
    private final String SQL_SELECT_ALL_RP="SELECT * FROM user WHERE role LIKE 'ROLE_RESPONSABLE_PRESTATION'";
    private final String SQL_SELECT_BY_ID="SELECT * FROM user WHERE role LIKE 'ROLE_RESPONSABLE_PRESTATION' AND id=?";
    private final String SQL_INSERT="";
    private final String SQL_SELECT_ALL_SEC="SELECT * FROM user WHERE role LIKE 'ROLE_PATIENT'";

    private final String SQL_SELECT_BY_ID_SEC="SELECT * FROM `rendez_vous`";

    @Override
    public int insert(ResponsablePrestation ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(ResponsablePrestation ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ResponsablePrestation> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponsablePrestation findById(int id) {
         ResponsablePrestation med  = null;
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_BY_ID);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_SELECT_BY_ID);
            if(rs.next()){
                med = new ResponsablePrestation();
                med.setId(rs.getInt("id"));
                med.setNom(rs.getString("nom"));
                med.setPrenom(rs.getString("Prenom"));
                

               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return med;
    }
    
    public List<ResponsablePrestation> findAllRp(){
        List<ResponsablePrestation> rps = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_ALL_RP);
        try {
            database.getPs();
            ResultSet rs = database.executeSelect(SQL_SELECT_ALL_RP);
            while(rs.next()){
                ResponsablePrestation rp = new ResponsablePrestation();
                rp.setId(rs.getInt("id"));
                rp.setNom(rs.getString("nom"));
                rp.setPrenom(rs.getString("Prenom"));
                rp.setLogin(rs.getString("login"));

                rps.add(rp);

            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return rps;
    
    }


}

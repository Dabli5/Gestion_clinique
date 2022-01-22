/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/
package dao;

import entities.Medecin;
import entities.RendezVous;
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
public class MedecinDao implements IDao{
    private final DataBase database= new DataBase();
    private final String SQL_INSERT = "INSERT INTO user"
            + "(`login`,`password`,`nom`,`prenom`,`statut`,`role`)"
            + "VALUES(?,?,?,?,?,'ROLE_MEDECIN')";
    
    private final String SQL_SELECT_ALL = "SELECT * FROM user WHERE role LIKE 'ROLE_MEDECIN'";
    private final String SQL_SELECT_BY_MEDECIN = "SELECT * FROM user WHERE role LIKE 'ROLE_MEDECIN' AND id=?";

    @Override
    public int insert(Object ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Object ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Medecin findById(int id) {
        Medecin med  = null;
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_BY_MEDECIN);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_SELECT_BY_MEDECIN);
            if(rs.next()){
                med = new Medecin();
                med.setId(rs.getInt("id"));
                med.setNom(rs.getString("nom"));
                med.setPrenom(rs.getString("Prenom"));
                med.setStatut(rs.getString("Statut"));

               

            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return med;
    }
    public List<Medecin> findAllMedecin(){
        List<Medecin> meds = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_ALL);
        try {
            database.getPs();
            ResultSet rs = database.executeSelect(SQL_SELECT_ALL);
            while(rs.next()){
                Medecin med = new Medecin();
                med.setId(rs.getInt("id"));
                med.setNom(rs.getString("nom"));
                med.setPrenom(rs.getString("Prenom"));
                med.setStatut(rs.getString("Statut"));

                meds.add(med);

            }
        } catch (SQLException ex) {
            Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }return meds;
    
    }
}
    


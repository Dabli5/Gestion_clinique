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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mr Demba Ndiaye
 */
public class PatientDao implements IDao<Patient>{
    //création d'un objet  database dans patient
    private final DataBase database= new DataBase();
    
    //requete SQL pour un INSERT de patient
    private final String SQL_INSERT="INSERT INTO `user`"
            + "(`login`,`password`,`nom`,`prenom`,`role`,`code`)"
            + "VALUES(?,?,?,?,?,?)";
    
    //requete SQL pour une Update
    private final String SQL_SELECT_ALL="SELECT * FROM user WHERE role LIKE 'ROLE_PATIENT'";
    private final String SQL_SELECT_ALL_PAT="SELECT * FROM user WHERE role LIKE 'ROLE_PATIENT'";
    private final String SQL_SELECT_BY_ID="SELECT * FROM `user` WHERE role LIKE 'ROLE_PATIENT' AND id = ?";
            
//code d'nsertion par etape bien def
    @Override
    public int insert(Patient pat) {
        int id=0;
        database.openConnexion();
        //chargement de la base de donnee et des requetes
        database.initPrepareStatement(SQL_INSERT);
        try {
            database.getPs().setString(1, pat.getLogin());
            database.getPs().setString(2, pat.getPassword());
            database.getPs().setString(3, pat.getNom());
            database.getPs().setString(4, pat.getPrenom());
            database.getPs().setString(6, pat.getCode());
            database.getPs().setString(5,"ROLE_PATIENT");
            System.out.println(pat.getLogin() +" "+pat.getPassword()+"  "+pat.getNom()+" "+pat.getPrenom()+" "+pat.getCode());
            database.executeUpdate(SQL_INSERT); 
            ResultSet rs= database.getPs().getGeneratedKeys();
            if(rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }return id;
    }

    @Override
    public int update(Patient ogj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patients= new ArrayList();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_ALL);
        try{
            ResultSet rs= database.executeSelect(SQL_SELECT_ALL);
            while(rs.next()){
                Patient pat = new Patient(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"),rs.getString("code"));
                patients.add(pat);
            }
        }catch(SQLException ex){
           Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();
        } 
        
        return patients;
    }

    @Override
    public Patient findById(int id) {
        Patient pat=null;
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_BY_ID);
        try{
            database.getPs().setInt(1, id);
            ResultSet rs= database.executeSelect(SQL_SELECT_BY_ID);
            if(rs.next()){
                pat= new Patient();
                        pat.setId(rs.getInt("id"));
                        pat.setNom(rs.getString("nom"));
                        pat.setPrenom(rs.getString("prenom"));
                        pat.setLogin(rs.getString("login"));
                        pat.setPassword(rs.getString("password"));
                        pat.setCode(rs.getString("code"));
            }
        }catch(SQLException ex){
           Logger.getLogger(RendezVousDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            database.closeConnexion();
        } 
        return pat;
    }
public List<Patient> findAllPatient(){
        List<Patient> pats = new ArrayList<>();
        database.openConnexion();
        database.initPrepareStatement(SQL_SELECT_ALL_PAT);
        try {
            database.getPs();
            ResultSet rs = database.executeSelect(SQL_SELECT_ALL_PAT);
            while(rs.next()){
                Patient pts = new Patient();
                pts.setId(rs.getInt("id"));
                pts.setNom(rs.getString("nom"));
                pts.setPrenom(rs.getString("Prenom"));
                pats.add(pts);

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }return pats;
    
    }
    
        
       
    
}

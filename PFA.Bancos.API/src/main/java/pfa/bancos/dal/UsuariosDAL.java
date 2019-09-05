/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pfa.bancos.model.Usuario;

/**
 *
 * @author Brian
 */
public class UsuariosDAL extends DataAccessLayer{
    
    public Usuario Login(String username, String password)
    {
        String query = "SELECT * FROM Usuario WHERE Nombre = '" + username + "' and contraseña = '" + password + "'";
        ResultSet rs = EjecutarConsulta(query);
        try {
            rs.next();
            return new Usuario(rs.getString("Nombre"), rs.getString("Contraseña"), rs.getInt("Id"), rs.getInt("RolID"));
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public void crear(String username, String password, int rolId)
    {
        
        String query = "INSERT INTO Usuario VALUES ('" + username + "', '" + password + "',NULL, " + rolId + ")";
        //String query = "INSERT INTO Usuario VALUES ('" + username + "', " + edad + ", '" + nombre + "', '" + usuario + "')";
        try {
            EjecutarUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
    }

    public ArrayList<Usuario> getUsuarios() {
        String query = "SELECT * FROM Usuario";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        try {
            while(rs.next())
            {
                usuarios.add(new Usuario(rs.getString("Nombre"), 
                        rs.getString("Contraseña"), rs.getInt("ID"), rs.getInt("RolID")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return usuarios;
    }
    
    public void eliminar(int codigo)
    {
        
        String query = "DELETE FROM Usuario Where ID = '" + codigo +"'";
         try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "No se ha podido eliminar la entidad, asegurese que no hayan entidades relacionadas a ésta: " +ex.getMessage() , "ERROR", JOptionPane.ERROR);
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public Usuario getObtenerUsuarioPorID(int id){
        ResultSet rs = EjecutarConsulta("SELECT * FROM Usuario WHERE ID = " + id + "");
        try {
            rs.next();
            return new Usuario(rs.getString("Nombre"), rs.getString("Contraseña"), rs.getInt("ID"), rs.getInt("RolID"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAL.class.getName()).log(Level.SEVERE, null, "No se encontró el Usuario con ID: " + id + " // " + ex);
            return null;
        }        
    }

    public void guardarUsuario(String nombre, String contraseña,int id) {
        String query = "UPDATE Usuario SET Nombre = '" + nombre + "', Contraseña = '" + contraseña + "' WHERE ID = " + id + "";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
        
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.dal;

import static java.sql.JDBCType.NULL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pfa.bancos.model.EntidadBancaria;
import sun.security.util.Length;

/**
 *
 * @author Brian
 */
public class EntidadesBancariasDAL extends DataAccessLayer {
    
    public ArrayList<EntidadBancaria> obtenerEntidades()
    {
        String query = "SELECT * FROM entidadbancaria";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<EntidadBancaria> entidades = new ArrayList<>();
        try {
            while(rs.next())
            {
                try {
                    entidades.add(new EntidadBancaria(rs.getString("Codigo"), rs.getString("Nombre"), rs.getString("Domicilio")));
                } catch (SQLException ex) {
                    Logger.getLogger(EntidadesBancariasDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesBancariasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entidades;
    }
    
    public void eliminar(String codigo)
    {
        SucursalDAL sDAL = new SucursalDAL();
        sDAL.eliminarPorCodigoEntidad(codigo);
        String query = "DELETE FROM EntidadBancaria Where Codigo = '" + codigo +"'";
         try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "No se ha podido eliminar la entidad, asegurese que no hayan entidades relacionadas a ésta: " +ex.getMessage() , "ERROR", JOptionPane.ERROR);
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public EntidadBancaria obtenerEntidadPorCodigo(String codigo)
    {
        String query = "SELECT * FROM entidadbancaria WHERE Codigo = '" +codigo + "'";
        ResultSet rs = EjecutarConsulta(query);        
        try {
            while(rs.next())
            {
                try {
                    return new EntidadBancaria(rs.getString("Codigo"), rs.getString("Nombre"), rs.getString("Domicilio"));
                } catch (SQLException ex) {
                    Logger.getLogger(EntidadesBancariasDAL.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesBancariasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void editarEntidadBancaria(String codigo, String nombre, String domicilio)
    {
        String query = "UPDATE entidadbancaria SET Nombre = '" + nombre + "', Domicilio = '" + domicilio + "' WHERE Codigo = '" + codigo + "'";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(EntidadesBancariasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearEntidadBancaria(String codigo, String nombre, String domicilio)
    {
               
            String query = "INSERT INTO entidadbancaria VALUES ('" + codigo + "', '" + nombre + "', '" + domicilio + "')";
            try {
                EjecutarUpdate(query);
            } catch (SQLException ex) {
                Logger.getLogger(EntidadesBancariasDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
    
}

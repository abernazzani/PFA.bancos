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
import pfa.bancos.model.Banda;

/**
 *
 * @author Brian
 */
public class BandasDAL extends DataAccessLayer{

    public ArrayList<Banda> obtenerBandas()
    {
        String query = "SELECT * FROM Banda";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Banda> bandas = new ArrayList<Banda>();
        try {
            while(rs.next())
            {
                bandas.add(new Banda(rs.getString("CodigoBanda"), rs.getInt("NroDeMiembros")));
            }            
            return bandas;
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return bandas;
        }   
    }
    
    public Banda obtenerBanda(String codigo)
    {
        String query = "SELECT * FROM Banda Where CodigoBanda = '" + codigo + "'";
        ResultSet rs = EjecutarConsulta(query);
        try {
            rs.next();
            return new Banda(rs.getString("CodigoBanda"), rs.getInt("NroDeMiembros"));
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }
    
    public void crear(String codigo, int nroDelincuentes)
    {
        String query = "INSERT INTO Banda VALUES ('" + codigo + "', " + nroDelincuentes + ")";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(String codigo, int nroDelincuentes)
    {
        String query = "UPDATE Banda SET NroDeMiembros = " + nroDelincuentes + " WHERE CodigoBanda = '" + codigo + "'";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);            
        }
    }
    
    public void eliminar(String codigo)
    {
        String query = "DELETE FROM Banda WHERE CodigoBanda = '" + codigo + "'";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "No se ha podido eliminar la entidad, asegurese que no hayan entidades relacionadas a ésta: " + ex.getMessage() , "ERROR", JOptionPane.OK_OPTION);
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}

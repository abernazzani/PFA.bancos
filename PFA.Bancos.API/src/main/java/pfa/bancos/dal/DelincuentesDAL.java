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
import pfa.bancos.model.Delincuente;


/**
 *
 * @author Brian
 */
public class DelincuentesDAL extends DataAccessLayer {
    
    public ArrayList<Delincuente> getDelincuentes()
    {
        String query = "SELECT * FROM Delincuente";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Delincuente> delincuentes = new ArrayList<Delincuente>();
        try {
            while(rs.next())
            {
                delincuentes.add(new Delincuente(rs.getString("Codigo"), rs.getString("Nombre"), rs.getBoolean("Detenido"), rs.getString("CodigoBanda")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return delincuentes;
    }
    
    public Delincuente getPorCodigo(String codigo)
    {
        String query = "SELECT * FROM Delincuente Where Codigo = '" + codigo + "'";
        ResultSet rs = EjecutarConsulta(query);
        try {
            rs.next();
            return new Delincuente(rs.getString("Codigo"), rs.getString("Nombre"), rs.getBoolean("Detenido"), rs.getString("CodigoBanda"));
        } catch (SQLException ex) {
            Logger.getLogger(DelincuentesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Delincuente> getPorAsalto(int asaltoId)
    {
        String query = "SELECT * FROM delincuente WHERE Codigo IN (SELECT CodigoDelincuente FROM delincuentesporasalto Where AsaltoID = " + asaltoId + ")";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Delincuente> delincuentes = new ArrayList<Delincuente>();
        try {
            while(rs.next())
            {
                delincuentes.add(new Delincuente(rs.getString("Codigo"), rs.getString("Nombre"), rs.getBoolean("Detenido"), rs.getString("CodigoBanda")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return delincuentes;
    }
    
    public void eliminar(String codigo)
    {
        String query = "DELETE FROM Delincuente WHERE Codigo = '" + codigo + "'";
         try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "No se ha podido eliminar la entidad, asegurese que no hayan entidades relacionadas a ésta: " +ex.getMessage() , "ERROR", JOptionPane.ERROR);
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void crear(String codigo, String nombre, boolean detenido, String codigoBanda)
    {
        String cBanda = (codigoBanda == null ? "null" : "'" + codigoBanda + "'");
        String query = "INSERT INTO Delincuente VALUES ('" + codigo + "', '" + nombre + "', " + ((detenido) ? 1 : 0)  + ", "+ cBanda + ")";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DelincuentesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardar(String codigo, String nombre, boolean detenido, String codigoBanda)
    {
        String cBanda = (codigoBanda == null ? "null" : "'" + codigoBanda + "'");
        String query = "UPDATE Delincuente SET Nombre = '" + nombre + "', Detenido = " + ((detenido) ? 1 : 0) + ", CodigoBanda = " + cBanda +
                " WHERE Codigo = '" + codigo + "'";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DelincuentesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

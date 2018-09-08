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
import pfa.bancos.model.Sucursal;

/**
 *
 * @author Alumno
 */
public class SucursalDAL extends DataAccessLayer {
    
    public void crearSucursal(String codigoEntidad, String codigo, String domicilio, int nroEmpleados)
    {
        String query = "INSERT INTO Sucursal VALUES ('" + codigo + "', '" + domicilio + "', " + nroEmpleados + ", '" + codigoEntidad +"')";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void guardarSucursal(String codigo, String domicilio, int nroEmpleados)
    {
        String query = "UPDATE Sucursal SET domicilio = '" + domicilio + "', nroEmpleados = " + nroEmpleados + " WHERE codigo = '" + codigo + "'";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarPorCodigoEntidad(String codigo)
    {
        String query = "DELETE FROM Sucursal Where CodigoEntidad = '" + codigo + "'";
         try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "No se ha podido eliminar la entidad, asegurese que no hayan entidades relacionadas a ésta: " +ex.getMessage() , "ERROR", JOptionPane.ERROR);
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public void eliminar(String codigo)
    {
        String query = "DELETE FROM Sucursal Where Codigo = '" + codigo + "'";
         try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "No se ha podido eliminar la entidad, asegurese que no hayan entidades relacionadas a ésta: " +ex.getMessage() , "ERROR", JOptionPane.ERROR);
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    public Sucursal getSucursalPorCodigo(String codigo)
    {        
        ResultSet rs = EjecutarConsulta("SELECT * FROM Sucursal WHERE Codigo = '" + codigo + "'");
        try {
            rs.next();
            return new Sucursal(rs.getString("Codigo"), rs.getString("Domicilio"), rs.getInt("NroEmpleados"), rs.getString("CodigoEntidad"));
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, "No se encontró la sucursal con codigo: " + codigo + " // " + ex);
            return null;
        }        
    }
    
    public ArrayList<Sucursal> getSucursales()
    {        
        ResultSet rs = EjecutarConsulta("SELECT * FROM Sucursal");
        ArrayList<Sucursal> sucursales = new ArrayList<>();

        try {
            while(rs.next())
            {
                sucursales.add(new Sucursal(rs.getString("Codigo"), rs.getString("Domicilio"), rs.getInt("NroEmpleados"), rs.getString("CodigoEntidad")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucursales;
    }
    
    public ArrayList<Sucursal> getSucursalesPorCodigoEntidad(String codigoEntidad)
    {        
        ResultSet rs = EjecutarConsulta("SELECT * FROM Sucursal WHERE CodigoEntidad = '" + codigoEntidad + "'");
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        
        try {
            while(rs.next())
            {
                sucursales.add(new Sucursal(rs.getString("Codigo"), rs.getString("Domicilio"), rs.getInt("NroEmpleados"), rs.getString("CodigoEntidad")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sucursales;
    }
}

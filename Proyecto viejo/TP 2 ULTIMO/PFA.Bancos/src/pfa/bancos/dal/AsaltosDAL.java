/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.dal;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pfa.bancos.model.Asalto;

/**
 *
 * @author Brian
 */
public class AsaltosDAL extends DataAccessLayer {
    
    public ArrayList<Asalto> getAsaltosPorDelincuente(String codigoDelincuente)
    {
        return null;
    }            
    
    public ArrayList<Asalto> getAsaltos()
    {
        String query = "SELECT * FROM Asalto";
        
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Asalto> asaltos = new ArrayList<>();
        try {
            while(rs.next())
            {
                asaltos.add(new Asalto(rs.getInt("Id"), rs.getDate("Fecha"), rs.getString("CodigoSucursal"), rs.getString(("CodigoJuez"))));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return asaltos;
    }
    
    public Asalto getAsaltoPorId(int id)
    {
        String query = "SELECT * FROM Asalto WHERE Id = " + id;
        ResultSet rs = EjecutarConsulta(query);
        try {
            rs.next();
            return new Asalto(rs.getInt("Id"), rs.getDate("Fecha"), rs.getString("CodigoSucursal"), rs.getString(("CodigoJuez")));
        }catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    }
    
    public ArrayList<Asalto> getAsaltoPorSucursal(String codigoSucursal)
    {
        return null;
    }
    
    
    public void guardar(int id, String fecha, String codigoJuez, String codigoSucursal, ArrayList<String> delincuentes)
    {
        String query = "UPDATE asalto SET Fecha = '" + fecha + "', CodigoJuez = '" +  codigoJuez + "', CodigoSucursal = '" + codigoSucursal + "' Where Id = " + id;
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(AsaltosDAL.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try {
            String removeQuery = "DELETE FROM delincuentesporasalto where AsaltoID = " + id;
            EjecutarUpdate(removeQuery);
                
            for(String codigoDelincuente : delincuentes)
            {
                String newQuery = "INSERT INTO DelincuentesPorAsalto VALUES ('"  + codigoDelincuente + "', " + id + ")";
                EjecutarUpdate(newQuery);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsaltosDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crear(String fecha, String codigoJuez, String codigoSucursal, ArrayList<String> delincuentes)
    {
        String query = "INSERT INTO `asalto`(`Fecha`, `CodigoSucursal`, `CodigoJuez`) VALUES ('" + fecha + "', '" + codigoSucursal + "', '" + codigoJuez + "')";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(AsaltosDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query2 = "SELECT Id FROM Asalto Where Fecha = '" + fecha + "' and codigoSucursal = '" + codigoSucursal + "'";        
        ResultSet rs = EjecutarConsulta(query2);
        try {
            rs.next();
            int id = rs.getInt("Id");
            for(String codigoDelincuente : delincuentes)
            {
                String newQuery = "INSERT INTO DelincuentesPorAsalto VALUES ('"  + codigoDelincuente + "', " + id + ")";
                EjecutarUpdate(newQuery);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsaltosDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarAsalto(int id)
    {
        
    }
}

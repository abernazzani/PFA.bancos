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
import pfa.bancos.model.Delincuente;
import pfa.bancos.model.Vigilante;

/**
 *
 * @author Brian
 */
public class VigilantesDAL extends DataAccessLayer {
           
    public void crear(String codigo, String nombre, int edad, String usuario)
    {
       String query = "INSERT INTO Vigilante VALUES ('" + codigo + "', " + edad + ", '" + nombre + "', '" + usuario + "')";
        try {
            EjecutarUpdate(query);
            
        } catch (SQLException ex) {
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        } 
       
               
    }
    
    public void eliminar(String codigo)
    {
        
    }
    
    public Vigilante getPorCodigo(String usuario)
    {
        String query = "SELECT * FROM Vigilante Where Usuario = '" + usuario + "'";
        ResultSet rs = EjecutarConsulta(query);
        try {
            rs.next();
            return new Vigilante(rs.getString("Codigo"), rs.getInt("Edad"), rs.getString("Nombre"), rs.getString("Usuario"));
        } catch (SQLException ex) {
            Logger.getLogger(DelincuentesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;      
       
        
    }
 
    public ArrayList<Vigilante> getVigilantes()
    {
        String query = "SELECT * FROM Vigilante";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Vigilante> vigilantes = new ArrayList<>();
        try {
            while(rs.next())
            {
                vigilantes.add(new Vigilante(rs.getString("Codigo"), 
                        rs.getInt("Edad"), rs.getString("Nombre"), rs.getString("Usuario")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return vigilantes;
    }
}

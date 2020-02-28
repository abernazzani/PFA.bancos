/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.dal;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import pfa.bancos.model.Banda;
import pfa.bancos.model.Contratacion;
/**
 *
 * @author Brian
 */
public class ContratacionesDAL extends DataAccessLayer {
	
	
	
    
    public void crear(String codigoSucursal, String codigoVigilante, String fecha, boolean armas)
    {
        String query = "INSERT INTO contratacion VALUES ('" + codigoSucursal + "', '" + codigoVigilante + "', '" + fecha + "', " + ((armas) ? 1 : 0) +")";
        try {
        	System.out.println(query);
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ContratacionesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    
    public void guardar(String codigoSucursal, String codigoVigilante, String fecha, boolean armas)
    {
        
    	//String query = "INSERT INTO contratacion VALUES ('" + codigoSucursal + "', '" + codigoVigilante + "', '" + fecha + "', " + armas +")";
        
        String query = "UPDATE Contratacion SET CodigoSucursal = '" + codigoSucursal + "', CodigoVigilante = '" + codigoVigilante + "', Fecha = '" + fecha + "' , Armas = " + ((armas) ? 1 : 0) +
                " WHERE CodigoSucursal = '" + codigoSucursal + "' and Fecha = '" + fecha + "'"; 
        
        System.out.println(query);
        
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DelincuentesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    public ArrayList<Contratacion> getContrataciones(){
        String query = "SELECT * FROM contratacion";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
        try {
            while(rs.next())
            {
            	contrataciones.add(new Contratacion(rs.getString(1),rs.getString(2), rs.getString(3),rs.getBoolean(4)));
            	System.out.println( rs.getDate(3));
            	
            	//contrataciones.add(new Contratacion(rs.getString("CodigoSucursal"), rs.getString("CodigoVigilante"), rs.getDate("Fecha"),rs.getBoolean("Armas")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return contrataciones;
    }
    
    
    public ArrayList<Contratacion> getContratacionesPorCodigoSucursal(String codigo)
    {        
        ResultSet rs = EjecutarConsulta("SELECT * FROM Contratacion WHERE codigoSucursal = '" + codigo + "'");
        ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
        try {
            while(rs.next())
            {
                
            	contrataciones.add(new Contratacion(rs.getString("CodigoSucursal"), rs.getString("CodigoVigilante"), rs.getString("Fecha"),rs.getBoolean("Armas")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return contrataciones;      
    }   
    
    
    public ArrayList<Contratacion> getContratacionesPorFecha(String fecha)
    {        
        ResultSet rs = EjecutarConsulta("SELECT * FROM Contratacion WHERE Fecha = '" + fecha + "'");
        ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
        try {
            while(rs.next())
            {
                contrataciones.add(new Contratacion(rs.getString("CodigoSucursal"), rs.getString("CodigoVigilante"), rs.getString("Fecha"),rs.getBoolean("Armas")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return contrataciones;      
    } 
    
    
    
    public ArrayList<Contratacion> getContratacionesPorCodigoVigilante(String codigo)
    {        
        ResultSet rs = EjecutarConsulta("SELECT * FROM Contratacion WHERE codigoVigilante = '" + codigo + "'");
        ArrayList<Contratacion> contrataciones = new ArrayList<Contratacion>();
        try {
            while(rs.next())
            {
                contrataciones.add(new Contratacion(rs.getString("CodigoSucursal"), rs.getString("CodigoVigilante"), rs.getString("Fecha"),rs.getBoolean("Armas")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return contrataciones;      
    } 
    
    
    public Contratacion getPorFechaYCodVigilante(String codigoVigilante, String fecha)
    { 
    	
    	String query = "SELECT * FROM Contratacion WHERE CodigoVigilante = '" + codigoVigilante + "' and Fecha = '" + fecha + "'";
    	//String query = "SELECT * FROM Contratacion WHERE CodigoVigilante = '" + codigoVigilante + "'";
    	
    	ResultSet rs = EjecutarConsulta(query);
        
    	 Contratacion contratacion = new Contratacion();
        
    	try {
    		if(rs.next()) {
    			System.out.println("rs ok"); 
    		//rs.next();
    			return  contratacion = new Contratacion(rs.getString("CodigoSucursal"), rs.getString("CodigoVigilante"), rs.getString("Fecha"),rs.getBoolean("Armas"));
                // contrataciones.add(new Contratacion(rs.getString("CodigoSucursal"), rs.getString("CodigoVigilante"), rs.getDate("Fecha"),rs.getBoolean("Armas")));
    			
    		}else {
    			System.out.println("rs null"); 
    			return null;
    			
    		}
    		       
          
                        
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
      
    	
     /*   ResultSet rs = EjecutarConsulta("SELECT * FROM Contratacion WHERE CodigoVigilante = '" + codigoVigilante + "' and Fecha = '" + fecha + "'");
      
        try {
           rs.next();         
           
           return new Contratacion(rs.getString("CodigoSucursal"),rs.getString("CodigoVigilante"),rs.getDate("Fecha"), rs.getBoolean("Armas"));
          
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return null;
    */
    }
    
    public void eliminar(String codigoVigilante, String fecha)
    {
        
        String query = "DELETE FROM Contratacion Where CodigoVigilante = '" + codigoVigilante + "' and Fecha = '" + fecha + "'";

         try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
                //JOptionPane.showConfirmDialog(null, "No se ha podido eliminar la contratacion, asegurese que no hayan entidades relacionadas a ésta: " +ex.getMessage() , "ERROR", JOptionPane.ERROR);
            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }    
       
        
           
    
    
}

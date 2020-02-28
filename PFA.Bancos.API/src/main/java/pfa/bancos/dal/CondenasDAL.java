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
import pfa.bancos.model.Banda;
import pfa.bancos.model.Condena;
import pfa.bancos.model.Contratacion;

/**
 *
 * @author Brian
 */
public class CondenasDAL extends DataAccessLayer {
    
    public void create(String codigoDelincuente, int asaltoId, String fechaInicio, String fechaFin)
    {
        String query = "INSERT INTO condena VALUES ('" + codigoDelincuente + "', " + asaltoId + ", '" + fechaInicio + "', '" + fechaFin + "')";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(AsaltosDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Condena> getCondenasPorAsalto(int asaltoId)
    {
        String query = "SELECT * FROM Condena Where CodigoAsalto = " + asaltoId;
        ResultSet rs = EjecutarConsulta(query);
        
        ArrayList<Condena> response = new ArrayList<Condena>();
        try {
            while(rs.next())
            {
            response.add(new Condena(rs.getString("CodigoDelincuente"), rs.getInt("CodigoAsalto"), rs.getDate("FechaDeInicio"), rs.getDate("FechaFin")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return response;
    }
    
    public void setearCondena(ArrayList<Condena> condenas, int asaltoId)
    {
        String query = "DELETE FROM Condena Where AsaltoId = " + asaltoId;
        try {
            EjecutarUpdate(query);
            for(Condena condena : condenas)
            {
                String query2 = "INSERT INTO Condena VALUES ('" +condena.getCodigoDelDelincuente() +"', '" +
                        String.valueOf(condena.getCodigoAsalto()) + "', '" + condena.getFechaDeInicio().toString() + "', '" +
                        condena.getFechaFin().toString() + "')";
                EjecutarUpdate(query2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CondenasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Condena> getCondenas(){
    	String query = "SELECT * FROM Condena";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Condena> condenas = new ArrayList<Condena>();
        try {
            while(rs.next())
            {
                condenas.add(new Condena(rs.getString("CodigoDelincuente"),rs.getInt("CodigoAsalto"),rs.getString("FechaDeInicio"),rs.getString("FechaFin")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return condenas;
    }
    	
    	
    	
    
    
    public ArrayList<Condena> getCondenaPorDelincuente(String codigoDelincuente)
    {
        return null;
    }
    
    public Condena getCondenasPorDelincuenteyAsalto(String codigoD,int codigoA)
    {
        String query = "SELECT * FROM Condena Where CodigoAsalto = " + codigoA + " and CodigoDelincuente = '" + codigoD +"'";
        ResultSet rs = EjecutarConsulta(query);
        
        Condena response = new Condena();
        
        
        try {
            if(rs.next())
            {
            
            	return response = new Condena(rs.getString("CodigoDelincuente"), rs.getInt("CodigoAsalto"), rs.getString("FechaDeInicio"), rs.getString("FechaFin"));
            }
            else {
            	return null;
            	
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }   
        //return response;
        return null;
    }
       
        
    public void update(Condena condena)
    {
        String query = "UPDATE Condena SET CodigoDelincuente = '" + condena.getCodigoDelincuente() + "', CodigoAsalto = " + condena.getCodigoAsalto() + ", FechaDeInicio = '" + condena.getFechaDeInicio() +  "', FechaFin = '" + condena.getFechaFin() + "' Where CodigoDelincuente = '" + condena.getCodigoDelincuente() + "' and CodigoAsalto = "  + condena.getCodigoAsalto() + "";
        try {
            EjecutarUpdate(query);
           
            }
        catch (SQLException ex) {
            Logger.getLogger(CondenasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(String CodigoDelincuente, int  CodigoAsalto)
    {
    	String query = "DELETE FROM Condena Where CodigoDelincuente = '" + CodigoDelincuente + "' and CodigoAsalto = "  + CodigoAsalto + "";
    	
    	try {
            EjecutarUpdate(query);
           
            }
        catch (SQLException ex) {
            Logger.getLogger(CondenasDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

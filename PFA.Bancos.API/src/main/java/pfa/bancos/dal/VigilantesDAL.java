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

//import pfa.bancos.model.Delincuente;
import pfa.bancos.model.Vigilante;

/**
 *
 * @author Brian
 */
public class VigilantesDAL extends DataAccessLayer {

	public void crear(String codigo, String nombre, String fechaNac, String usuario) {
		String query = "INSERT INTO Vigilante VALUES ('" + codigo + "', '" + fechaNac + "', '" + nombre + "', '" + usuario	+ "')";
		try {
			EjecutarUpdate(query);

		} catch (SQLException ex) {
			Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	

	public void guardarVigilante(String codigo, String nombre, String fechaNac, String usuario) {
        
		String query = "UPDATE Vigilante SET Usuario = '" + usuario + "', Nombre = '" + nombre + "', FechaNac = '" + fechaNac + "' WHERE Codigo = '" + codigo + "'";
        System.out.println(query);
		
		try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
	
	}
	

	public void eliminar(String codigo) {		
	        
	        String query = "DELETE FROM Vigilante Where Codigo = '" + codigo +"'";
	         try {
	            EjecutarUpdate(query);
	        } catch (SQLException ex) {
	            JOptionPane.showConfirmDialog(null, "No se ha podido eliminar entidad, asegurese que no hayan entidades relacionadas a ésta: " +ex.getMessage() , "ERROR", JOptionPane.ERROR);
	            Logger.getLogger(BandasDAL.class.getName()).log(Level.SEVERE, null, ex);
	        }   
	    
		

	}
	
	public Vigilante getPorCodigo(String codigo) {
		String query = "SELECT * FROM Vigilante Where Codigo = '" + codigo + "'";
		ResultSet rs = EjecutarConsulta(query);
		try {
			rs.next();
			return new Vigilante(rs.getString("Codigo"), rs.getString("FechaNac"), rs.getString("Nombre"),
					rs.getString("Usuario"));
		} catch (SQLException ex) {
			Logger.getLogger(DelincuentesDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;

	}

	public Vigilante getPorNombre(String usuario) {
		String query = "SELECT * FROM Vigilante Where Usuario = '" + usuario + "'";
		ResultSet rs = EjecutarConsulta(query);
		try {
			rs.next();
			return new Vigilante(rs.getString("Codigo"), rs.getString("FechaNac"), rs.getString("Nombre"),
					rs.getString("Usuario"));
		} catch (SQLException ex) {
			Logger.getLogger(DelincuentesDAL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;

	}

	public ArrayList<Vigilante> getVigilantes() {
		String query = "SELECT * FROM Vigilante";
		ResultSet rs = EjecutarConsulta(query);
		ArrayList<Vigilante> vigilantes = new ArrayList<Vigilante>();
		try {
			while (rs.next()) {
				vigilantes.add(new Vigilante(rs.getString("Codigo"), rs.getString("FechaNac"), rs.getString("Nombre"),
						rs.getString("Usuario")));
			}
		} catch (SQLException ex) {
			Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
		return vigilantes;
	}
}

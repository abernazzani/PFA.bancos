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
import javax.swing.JOptionPane;
import pfa.bancos.model.Juez;

/**
 *
 * @author Brian
 */
public class JuecesDAL extends DataAccessLayer{
    public ArrayList<Juez> getJueces()
    {
        String query = "SELECT * FROM Juez";
        ResultSet rs = EjecutarConsulta(query);
        ArrayList<Juez> jueces = new ArrayList<Juez>();
        try {
            while(rs.next())
            {
                jueces.add(new Juez(rs.getString("Nombre"), rs.getString("Codigo"), rs.getDate("FechaDeIngreso")));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(SucursalDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }   
        return jueces;
    }
    
    public Juez getJuezPorAsalto(int asaltoId)
    {
        return null;
    }
    
    public void crear(String nombre, String codigo, Date date)
    {
        String query = "INSERT INTO Juez VALUES ('" + nombre + "', '" + codigo + "', '" + date + "')";
        try {
            EjecutarUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(JuecesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminar(String codigo) throws SQLException
    {
        String query = "DELETE FROM Juez Where Codigo = '" + codigo + "'";
         
            EjecutarUpdate(query);
        
        
        
        
        
    }
}

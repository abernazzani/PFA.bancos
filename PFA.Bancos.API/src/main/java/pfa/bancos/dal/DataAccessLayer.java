/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alumno
 */
public class DataAccessLayer {
    
    protected void EjecutarUpdate(String consulta) throws SQLException
    {
        try {            
            String url = "jdbc:mysql://localhost:3306/";
            String db = "pfa.bancos";
            //String driver = "com.mysql.jdbc.Driver";
            //Class.forName(driver);
            Connection conexion = DriverManager.getConnection(url + db, "root", "");
            Statement st = conexion.createStatement();
            st.executeUpdate(consulta);                  
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected static ResultSet EjecutarConsulta(String consulta)
    {       
        try {            
            String url = "jdbc:mysql://localhost:3306/";
            String db = "pfa.bancos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            //String driver = "com.mysql.jdbc.Driver";
            //Class.forName(driver);
            Connection conexion = DriverManager.getConnection(url + db, "root", "");
            Statement st = conexion.createStatement();            
            return st.executeQuery(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(DataAccessLayer.class.getName()).log(Level.SEVERE, null, ex);       
       
        }
        return null;
    }
}

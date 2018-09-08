/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.model;

import java.sql.Date;

/**
 *
 * @author silvana
 */
public class Asalto {
    private int id;
    private java.sql.Date fecha;
    private String codigoSucursal;
    private String  codigoJuez;        
    
    public Asalto(int id, Date fecha, String codigoSucursal, String codigoJuez)
    {
        this.id = id;
        this.fecha = fecha;
        this.codigoSucursal = codigoSucursal;
        this.codigoJuez = codigoJuez;
                   
    }
    
    public int getId ()
    {
        return id;
    }
    
    public Date getFecha ()
    {
        return fecha;
    }

    public String getCodigoSucursal ()
    {
       return codigoSucursal;
    }

    public String getCodigoJuez()
    {
       return codigoJuez;
    }
}

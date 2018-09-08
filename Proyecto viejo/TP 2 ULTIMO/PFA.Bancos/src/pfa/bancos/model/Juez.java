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
public class Juez {
    private String nombre;
    private String codigo;
    private Date fechaDeIngreso;
    
    public Juez(String nombre, String codigo, Date fechaDeIngreso)
    {
        this.nombre = nombre;
        this.codigo = codigo;
        this.fechaDeIngreso = fechaDeIngreso;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getCodigo()
    {
        return codigo;
    }
    
    public Date getFechaDeIngreso()
    {
        return fechaDeIngreso;
    }
}   

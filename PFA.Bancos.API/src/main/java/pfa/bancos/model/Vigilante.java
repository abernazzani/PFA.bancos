/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.model;

/**
 *
 * @author silvana
 */
public class Vigilante {
   
    private String codigo;
    private String fechaNac;
    private String nombre;
    private String usuario;
    
    public Vigilante() {
    	
    }
    
    public Vigilante(String codigo, String fechaNac, String nombre, String usuario)
    {
        this.codigo = codigo;
        this.fechaNac = fechaNac;
        this.nombre = nombre;
        this.usuario = usuario;       
    } 
    
    public String getCodigo()
    {
        return codigo;   
    }
    
    public String getFechaNac()
    {
        return fechaNac;   
    }
    
    public String getNombre()
    {    
        return nombre;
    }
    
    public String getUsuario()
    {
    
        return usuario;
    }
}

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
    private int edad;
    private String nombre;
    private String usuario;
    
    public Vigilante(String codigo, int edad, String nombre, String usuario)
    {
        this.codigo = codigo;
        this.edad = edad;
        this.nombre = nombre;
        this.usuario = usuario;       
    } 
    
    public String getCodigo()
    {
        return codigo;   
    }
    
    public int getEdad()
    {
        return edad;   
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

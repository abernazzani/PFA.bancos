/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.model;

/**
 *
 * @author Alumno
 */
public class EntidadBancaria {
    private String codigo;
    private String nombre;
    private String domicilio;
    
    public EntidadBancaria(String codigo, String nombre, String domicilio)
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }
    
    public String getCodigo()
    {
        return codigo;   
    }
    
    public String getNombre()
    {
        return nombre;   
    }
    
    public String getDomicilio()
    {
        return domicilio;   
    }
}

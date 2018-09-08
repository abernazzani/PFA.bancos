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
public class Rol {
    private int ID;
    private String nombre;
    
    public Rol(int ID, String nombre)
    {
        this.ID = ID;
        this.nombre = nombre;
    }
    
    public int setID()
    {
        return ID;
    }
    
    public String setNombre()
    {
        return nombre;
    }
}

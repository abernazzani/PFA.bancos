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
public class Delincuente {
    private String codigo;
    private String nombre;
    private Boolean detenido;
    private String codigoBanda;
    
    public Delincuente () {
    	
    }
    
    public Delincuente (String codigo, String nombre, Boolean detenido, String codigoBanda )
    {
        this.codigo = codigo;
        this.nombre = nombre;        
        this.detenido = detenido;
        this.codigoBanda = codigoBanda;
    }
    
    public String getCodigo ()
    {
        return codigo;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public Boolean getDetenido()
    {
        return detenido;
    }
    
    public String getCodigoBanda()
    {
        return codigoBanda;
    }
}

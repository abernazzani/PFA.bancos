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
public class Sucursal {
    private String codigo;
    private String domicilio;
    private int nroEmpleados;
    private String codigoEntidad;

    public Sucursal(String codigo, String domicilio, int nroEmpleado, String codigoEntidad) {
        this.codigo = codigo;
        this.domicilio = domicilio;
        this.nroEmpleados = nroEmpleado;
        this.codigoEntidad = codigoEntidad;
    }
    
    public String getCodigo()
    {
        return codigo;
    }
    
    public String getDomicilio()
    {
        return domicilio;
    }
    
    public int getNroEmpleados()
    {
        return nroEmpleados;
    }
    
    public String getCodigoEntidad()
    {
        return codigoEntidad;
    }
}

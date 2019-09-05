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
public class Condena {
    
    private Delincuente delincuente;
    private Asalto asalto;
    private String codigoDelincuente;
    private int codigoAsalto;
    private Date fechaDeInicio;
    private Date fechaFin;
    
    public Condena (Delincuente delincuente, Asalto asalto, Date fechaDeInicio, Date fechaFin)
    {
        this.codigoDelincuente = delincuente.getCodigo();
        this.codigoAsalto = asalto.getId();
        this.fechaDeInicio = fechaDeInicio;
        this.fechaFin = fechaFin;
    }
    
    public Condena (String codigoDelincuente, int codigoAsalto, Date fechaDeInicio, Date fechaFin)
    {
        this.codigoDelincuente = codigoDelincuente;
        this.codigoAsalto = codigoAsalto;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaFin = fechaFin;
    }

    public Condena(String codigoDelincuente, int asaltoId, java.util.Date fInicioDate, java.util.Date fFinDate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getCodigoDelDelincuente()
    {
        return codigoDelincuente;
    }
   
    public int getCodigoAsalto()
    {
        return codigoAsalto;
    }
    
    public Date getFechaDeInicio()
    {
        return fechaDeInicio;
    }

    public Date getFechaFin()
    {
        return fechaFin;
    }

}

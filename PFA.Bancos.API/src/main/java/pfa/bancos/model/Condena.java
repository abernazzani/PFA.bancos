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
    
    //private Delincuente delincuente;
    //private Asalto asalto;
    private String codigoDelincuente;
    private int codigoAsalto;
    private String fechaDeInicio;
    private String fechaFin;
    
    public Condena() {
    	
    }
    
    /*public Condena (String delincuente, String asalto, String fechaDeInicio, String fechaFin)
    {
        this.codigoDelincuente = delincuente;
        this.codigoAsalto = asalto;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaFin = fechaFin;
    }
    */
    public Condena (String codigoDelincuente, int codigoAsalto, String fechaDeInicio, String fechaFin)
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
    
    public String getCodigoDelincuente() {
		return codigoDelincuente;
	}

	public void setCodigoDelincuente(String codigoDelincuente) {
		this.codigoDelincuente = codigoDelincuente;
	}

	public void setCodigoAsalto(int codigoAsalto) {
		this.codigoAsalto = codigoAsalto;
	}

	public void setFechaDeInicio(String fechaDeInicio) {
		this.fechaDeInicio = fechaDeInicio;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getFechaDeInicio()
    {
        return fechaDeInicio;
    }

    public String getFechaFin()
    {
        return fechaFin;
    }

}

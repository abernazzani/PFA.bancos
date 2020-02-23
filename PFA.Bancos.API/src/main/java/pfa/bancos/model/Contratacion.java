/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa.bancos.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author silvana
 */
public class Contratacion {

	private String codigoSucursal;
	private String codigoVigilante;
	private Date fecha;
	private Boolean armas;

	 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 //String strDate = sdf.format(date);
	
	
	public Contratacion() {
		
	}


	public Contratacion(String codigoSucursal, String codigoVigilante, Date fecha, Boolean armas)
	{
		this.codigoSucursal = codigoSucursal;
		this.codigoVigilante = codigoVigilante;
		this.fecha = fecha;
		this.armas = armas;

	}

	public String getCodigoSucursal ()
	{
		return codigoSucursal;
	}

	public String getCodigoVigilante ()
	{
		return codigoVigilante;
	}

	public Date getFecha ()
	{
		return fecha;
	}

	public Boolean getArmas ()
	{
		return armas;
	}
}

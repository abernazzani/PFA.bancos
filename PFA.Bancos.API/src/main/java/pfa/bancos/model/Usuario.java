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
public class Usuario {
	private String nombre;
	private String contraseña;
	private int id;
	public int rolID;

	public Usuario() {

	}

	public Usuario(String nombre, String contraseña, int ID, int rolID) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.id = ID;
		this.rolID = rolID;

	}

	public String getNombre() {
		return nombre;
	}

	public String getContraseña() {
		return contraseña;

	}

	public int getId() {
		return id;
	}

	public int getRolID() {
		return rolID;
	}

}

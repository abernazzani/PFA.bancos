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
public class Banda {
    
    private String codigoBanda;
    private int nroDeMiembros;
    
    public Banda(String codigoBanda, int nroDeMiembro)
    {
        this.codigoBanda = codigoBanda;
        this.nroDeMiembros = nroDeMiembro;
    }  
    
    public String getCodigoBanda ()
    {
        return codigoBanda;
    }
    
    public int getNroDeMiembros()
    {
        return nroDeMiembros;
    }
    
}

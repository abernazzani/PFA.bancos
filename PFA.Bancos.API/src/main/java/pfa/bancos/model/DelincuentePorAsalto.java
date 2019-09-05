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
public class DelincuentePorAsalto {
    private String codigoDelincuente;
    private int asaltoID;
    
    public DelincuentePorAsalto(String codigoDelincuente, int asaltoID)
    {
        this.codigoDelincuente = codigoDelincuente;
        this.asaltoID = asaltoID;
    }

    public String setCodigoDelincuente()
    {
        return codigoDelincuente;
    }
    
    public int setAsaltoID()
    {
        return asaltoID;
    }


}


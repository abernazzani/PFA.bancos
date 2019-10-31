package pfa.bancos.model;

import java.util.ArrayList;

import pfa.bancos.model.Condena;

public class ArrayCondenaPorAsalto {

	private int asaltoId;
	private ArrayList<Condena> condenas;
	
	public ArrayCondenaPorAsalto() {				
		
	}
	
	public ArrayCondenaPorAsalto( ArrayList<Condena> condenas, int asalto) {
		this.condenas = condenas;
		this.asaltoId = asalto;
		
	}
	
	public int getAsaltoId() {
		return this.asaltoId;
	}

	public void setAsaltoId(int asaltoId) {
		this.asaltoId = asaltoId;
	}

	public ArrayList<Condena> getCondenas() {
		return this.condenas;
	}

	public void setCondena(ArrayList<Condena> condenas) {
		this.condenas = condenas;
	}


	
	
}
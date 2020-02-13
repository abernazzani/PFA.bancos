package io.progii.springboot.api.models;

import java.util.ArrayList;

import pfa.bancos.model.Asalto;

public class AsaltoRequestModel extends Asalto {
	ArrayList<String> delincuentes;
	
	public AsaltoRequestModel()
	{
		super();
	}
	
	public ArrayList<String> getDelincuentes() {
		return delincuentes;
	}
}

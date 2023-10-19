package com.pneubras.integrador.exceltooracle.Entities.Excel;

import java.util.List;

import jakarta.persistence.Entity;


public class PlanilhaPrecoControladoriaComercial {

	private List<Integer> codProd;
	private List<Double> price;
	private List<Integer> codTab;
	
	
	
	public PlanilhaPrecoControladoriaComercial() {

	}

	public PlanilhaPrecoControladoriaComercial(List<Integer> codProd, List<Double> price, List<Integer> codTab) {
		this.codProd = codProd;
		this.price = price;
		this.codTab = codTab;
	}
	
	public List<Integer> getCodProd() {
		return codProd;
	}
	public void setCodProd(List<Integer> codProd) {
		this.codProd = codProd;
	}
	public List<Double> getPrice() {
		return price;
	}
	public void setPrice(List<Double> price) {
		this.price = price;
	}
	public List<Integer> getCodTab() {
		return codTab;
	}
	public void setCodTab(List<Integer> codTab) {
		this.codTab = codTab;
	}
	
	
		
	
}

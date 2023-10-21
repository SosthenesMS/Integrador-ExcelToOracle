package com.pneubras.integrador.exceltooracle.Entities.Excel;

import java.util.List;

import jakarta.persistence.Entity;


public class PlanilhaPrecoControladoriaComercial {

	private List<Integer> nuTab;
	private List<Integer> codProd;
	private List<Double> vlrVendaNovo;
	
	
	
	public PlanilhaPrecoControladoriaComercial() {

	}

	public PlanilhaPrecoControladoriaComercial(List<Integer> codProd, List<Double> vlrVendaNovo, List<Integer> nuTab) {
		this.codProd = codProd;
		this.vlrVendaNovo = vlrVendaNovo;
		this.nuTab = nuTab;
	}
	
	public List<Integer> getCodProd() {
		return codProd;
	}
	public void setCodProd(List<Integer> codProd) {
		this.codProd = codProd;
	}
	public List<Double> getVlrVendaNovo() {
		return vlrVendaNovo;
	}
	public void setVlrVendaNovo(List<Double> vlrVendaNovo) {
		this.vlrVendaNovo = vlrVendaNovo;
	}
	public List<Integer> getNuTab() {
		return nuTab;
	}
	public void setNuTab(List<Integer> nuTab) {
		this.nuTab = nuTab;
	}
	
	
		
	
}

package com.pneubras.integrador.exceltooracle.Entities.Excel;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class PlanilhaExcelPrice {

	private List<Integer> codProd;
	private List<Double> price;
	private List<Double> codTab;
	
	
	
	public PlanilhaExcelPrice() {

	}

	public PlanilhaExcelPrice(List<Integer> codProd, List<Double> price, List<Double> codTab) {
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
	public List<Double> getCodTab() {
		return codTab;
	}
	public void setCodTab(List<Double> codTab) {
		this.codTab = codTab;
	}
	
	
		
	
}

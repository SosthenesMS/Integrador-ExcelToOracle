package com.pneubras.integrador.exceltooracle.Entities;

import jakarta.persistence.Entity;

@Entity
public class PlanilhaPrice {

	private Integer codProd;
	private double price;
	private Integer codTab;
	
	
	
	public PlanilhaPrice() {

	}
	
	
	public PlanilhaPrice(Integer codProd, double price, Integer codTab) {
		this.codProd = codProd;
		this.price = price;
		this.codTab = codTab;
	}
	
	
	public Integer getCodProd() {
		return codProd;
	}
	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getCodTab() {
		return codTab;
	}
	public void setCodTab(Integer codTab) {
		this.codTab = codTab;
	}
	
	
	
	
}

package com.pneubras.integrador.exceltooracle.DTO;



public class TblPrecoControladoriaComercialDTO {
	
	private Integer codId;
	private Integer codProd;
	private double price;
	private Integer codTab;
	
	
	
	public TblPrecoControladoriaComercialDTO() {
	
	}

	public TblPrecoControladoriaComercialDTO(Integer codId, Integer codProd, double price, Integer codTab) {
		this.codId = codId;
		this.codProd = codProd;
		this.price = price;
		this.codTab = codTab;
	}
	
	public Integer getCodId() {
		return codId;
	}
	public void setCodId(Integer codId) {
		this.codId = codId;
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

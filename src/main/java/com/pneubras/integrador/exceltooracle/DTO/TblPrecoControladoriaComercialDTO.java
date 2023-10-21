package com.pneubras.integrador.exceltooracle.DTO;

import com.pneubras.integrador.exceltooracle.Entities.Oracle.TblPrecoControladoriaComercial;

public class TblPrecoControladoriaComercialDTO {
	
	private Integer codId;
	private Integer nuTab;
	private Integer codProd;
	private double vlrVendaNovo;
	
	
	public TblPrecoControladoriaComercialDTO() {
	
	}

	public TblPrecoControladoriaComercialDTO(Integer codId, Integer codProd, double vlrVendaNovo, Integer nuTab) {
		this.codId = codId;
		this.codProd = codProd;
		this.vlrVendaNovo = vlrVendaNovo;
		this.nuTab = nuTab;
	}
	
	
	public TblPrecoControladoriaComercialDTO(TblPrecoControladoriaComercial obj) {
		this.codId = obj.getCodId();
		this.codProd = obj.getCodProd();
		this.vlrVendaNovo = obj.getVlrVendaNovo();
		this.nuTab = obj.getNuTab();
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
	public double getVlrVendaNovo() {
		return vlrVendaNovo;
	}
	public void setVlrVendaNovo(double vlrVendaNovo) {
		this.vlrVendaNovo = vlrVendaNovo;
	}
	public Integer getNuTab() {
		return nuTab;
	}
	public void setNuTab(Integer nuTab) {
		this.nuTab = nuTab;
	}

	
	
	
}

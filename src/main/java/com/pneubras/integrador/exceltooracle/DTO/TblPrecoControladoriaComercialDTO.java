package com.pneubras.integrador.exceltooracle.DTO;

import com.pneubras.integrador.exceltooracle.Entities.Oracle.TblPrecoControladoriaComercial;

public class TblPrecoControladoriaComercialDTO {
	
	private Integer codId;
	private Integer codProd;
	private double vlrVendaAtual;
	private Integer codTab;
	
	
	
	public TblPrecoControladoriaComercialDTO() {
	
	}

	public TblPrecoControladoriaComercialDTO(Integer codId, Integer codProd, double vlrVendaAtual, Integer codTab) {
		this.codId = codId;
		this.codProd = codProd;
		this.vlrVendaAtual = vlrVendaAtual;
		this.codTab = codTab;
	}
	
	
	public TblPrecoControladoriaComercialDTO(TblPrecoControladoriaComercial obj) {
		this.codId = obj.getCodId();
		this.codProd = obj.getCodProd();
		this.vlrVendaAtual = obj.getVlrVendaAtual();
		this.codTab = obj.getCodTab();
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
	public double getVlrVendaAtual() {
		return vlrVendaAtual;
	}
	public void setVlrVendaAtual(double price) {
		this.vlrVendaAtual = price;
	}
	public Integer getCodTab() {
		return codTab;
	}
	public void setCodTab(Integer codTab) {
		this.codTab = codTab;
	}

	
	
	
}

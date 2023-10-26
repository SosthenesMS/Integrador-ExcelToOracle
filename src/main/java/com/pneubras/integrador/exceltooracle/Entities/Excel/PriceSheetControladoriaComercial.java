package com.pneubras.integrador.exceltooracle.Entities.Excel;

import java.util.List;

public class PriceSheetControladoriaComercial {

	private List<Integer> nuTab;
	private List<Integer> codProd;
	private List<Double> vlrVenda;

	public PriceSheetControladoriaComercial() {

	}

	public PriceSheetControladoriaComercial(List<Integer> codProd, List<Double> vlrVenda, List<Integer> nuTab) {
		this.codProd = codProd;
		this.vlrVenda = vlrVenda;
		this.nuTab = nuTab;
	}

	public List<Integer> getCodProd() {
		return codProd;
	}

	public void setCodProd(List<Integer> codProd) {
		this.codProd = codProd;
	}

	public List<Double> getVlrVenda() {
		return vlrVenda;
	}

	public void setVlrVenda(List<Double> vlrVenda) {
		this.vlrVenda = vlrVenda;
	}

	public List<Integer> getNuTab() {
		return nuTab;
	}

	public void setNuTab(List<Integer> nuTab) {
		this.nuTab = nuTab;
	}

}

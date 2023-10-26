package com.pneubras.integrador.exceltooracle.DTO;

import com.pneubras.integrador.exceltooracle.Entities.Oracle.PriceControladoriaComercial;

public class PriceControladoriaComercialDTO {

	private Integer nutab;
	private Integer codprod;
	private Integer codlocal;
	private double vlrvenda;
	private String tipo;
	private String modbaseicms;

	public PriceControladoriaComercialDTO() {

	}

	public PriceControladoriaComercialDTO(PriceControladoriaComercial obj) {
		this.nutab = obj.getNutab();
		this.codprod = obj.getCodprod();
		this.codlocal = obj.getCodlocal();
		this.vlrvenda = obj.getVlrvenda();
		this.tipo = obj.getTipo();
		this.modbaseicms = obj.getModbaseicms();
	}

	public Integer getNutab() {
		return nutab;
	}

	public void setNutab(Integer nutab) {
		this.nutab = nutab;
	}

	public Integer getCodprod() {
		return codprod;
	}

	public void setCodprod(Integer codprod) {
		this.codprod = codprod;
	}

	public Integer getCodlocal() {
		return codlocal;
	}

	public void setCodlocal(int codlocal) {
		this.codlocal = codlocal;
	}

	public double getVlrvenda() {
		return vlrvenda;
	}

	public void setVlrvenda(double vlrvenda) {
		this.vlrvenda = vlrvenda;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getModbaseicms() {
		return modbaseicms;
	}

	public void setModbaseicms(String modbaseicms) {
		this.modbaseicms = modbaseicms;
	}

}

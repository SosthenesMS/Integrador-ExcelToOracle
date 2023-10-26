package com.pneubras.integrador.exceltooracle.Entities.Oracle;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TGFEXC")
public class PriceControladoriaComercial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer nutab;
	private Integer codprod;
	private Integer codlocal;
	private double vlrvenda;
	private String tipo;
	private String modbaseicms;

	public PriceControladoriaComercial() {

	}

	public PriceControladoriaComercial(Integer nutab, Integer codprod, Integer codlocal, double vlrvenda, String tipo,
			String modbaseicms) {
		this.nutab = nutab;
		this.codprod = codprod;
		this.codlocal = codlocal;
		this.vlrvenda = vlrvenda;
		this.tipo = tipo;
		this.modbaseicms = modbaseicms;
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

	@Override
	public int hashCode() {
		return Objects.hash(codprod, nutab);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PriceControladoriaComercial other = (PriceControladoriaComercial) obj;
		return Objects.equals(codprod, other.codprod) && Objects.equals(nutab, other.nutab);
	}

}

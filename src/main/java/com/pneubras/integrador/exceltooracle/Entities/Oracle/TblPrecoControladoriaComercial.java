package com.pneubras.integrador.exceltooracle.Entities.Oracle;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "TabelaPrecoControlComer")
public class TblPrecoControladoriaComercial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codId;
	private Integer nuTab;
	private Integer codProd;
	private double vlrVendaNovo;
	

	
	public TblPrecoControladoriaComercial() {
		
	}
	
	public TblPrecoControladoriaComercial(Integer codId, Integer codProd, double vlrVendaNovo, Integer nuTab) {
		this.codId = codId;
		this.codProd = codProd;
		this.vlrVendaNovo = vlrVendaNovo;
		this.nuTab = nuTab;
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
	

	@Override
	public int hashCode() {
		return Objects.hash(codId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TblPrecoControladoriaComercial other = (TblPrecoControladoriaComercial) obj;
		return Objects.equals(codId, other.codId);
	}
	
	
}

package com.pneubras.integrador.exceltooracle.Entities;

import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "Price")
public class Price {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codId;
	private Integer codProd;
	private double price;
	private Integer codTab;
	
	
	
	public Price() {
		
	}
	
	public Price(Integer codId, Integer codProd, double price, Integer codTab) {
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
		Price other = (Price) obj;
		return Objects.equals(codId, other.codId);
	}
	
	
	
}

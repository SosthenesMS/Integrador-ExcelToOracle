package com.pneubras.integrador.exceltooracle.Services;

import org.springframework.stereotype.Service;

import com.pneubras.integrador.exceltooracle.DTO.PriceDTO;
import com.pneubras.integrador.exceltooracle.Entities.Oracle.Price;

@Service
public class PriceService {

	
	
	
	public PriceDTO convertPriceToDTO(Price price) {
		PriceDTO priceDto = new PriceDTO();
		priceDto.setCodId(price.getCodId());
		priceDto.setCodProd(price.getCodProd());
		priceDto.setCodTab(price.getCodTab());
		priceDto.setPrice(price.getPrice());
		return priceDto;
	}
	
	
	public Price convertDTOToPrice(PriceDTO priceDto) {
		Price price = new Price();
		price.setCodId(priceDto.getCodId());
		price.setCodProd(priceDto.getCodProd());
		price.setCodTab(priceDto.getCodTab());
		price.setPrice(priceDto.getPrice());
		return price;
	}
	
	
}

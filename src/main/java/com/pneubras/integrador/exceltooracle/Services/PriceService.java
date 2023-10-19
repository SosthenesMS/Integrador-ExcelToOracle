package com.pneubras.integrador.exceltooracle.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pneubras.integrador.exceltooracle.DTO.PriceDTO;
import com.pneubras.integrador.exceltooracle.Entities.Excel.PlanilhaExcelPrice;
import com.pneubras.integrador.exceltooracle.Entities.Oracle.Price;
import com.pneubras.integrador.exceltooracle.Repositories.PriceRepository;


@Service
public class PriceService {

	
	@Autowired
	private PriceRepository priceRepository;
	
	
	public String saveDadosExcelToPriceDTO(PlanilhaExcelPrice excelPrice) {
		
		System.out.println("*****Cheguei no service*****");
		
		PriceDTO priceDto = new PriceDTO();
		
		List<Integer> codProd = excelPrice.getCodProd();
		for(int codprod: codProd) {
			priceDto.setCodProd(codprod);
			
			for(double price: excelPrice.getPrice()) {
				priceDto.setPrice(price);
				
				for(int codtab: excelPrice.getCodTab()) {
					priceDto.setCodTab(codtab);
					priceRepository.save(convertDTOToPrice(priceDto));
					
				}
			}
		}
		
		return "Dados inseridos com sucesso!";
	}
	
	
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

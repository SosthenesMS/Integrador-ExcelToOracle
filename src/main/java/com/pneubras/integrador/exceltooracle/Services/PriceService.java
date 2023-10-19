package com.pneubras.integrador.exceltooracle.Services;

import java.util.ArrayList;
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
	
	
	

	// Método para criar uma lista com vários obejtos únicos de PriceDTO
	public void convertPlanilhaExcelPriceToPriceDTOList(PlanilhaExcelPrice excelPrice) {

		List<Integer> codProdList = excelPrice.getCodProd();
		List<Double> priceList = excelPrice.getPrice();
		List<Integer> codTabList = excelPrice.getCodTab();

		List<PriceDTO> priceDTOToSave = new ArrayList<>();

		if (codProdList.size() == priceList.size() && priceList.size() == codTabList.size()) {

			for (int i = 0; i < codProdList.size(); i++) {

				PriceDTO priceDto = new PriceDTO();
				priceDto.setCodProd(codProdList.get(i));
				priceDto.setPrice(priceList.get(i));
				priceDto.setCodTab(codTabList.get(i));

				priceDTOToSave.add(priceDto);
			}
			
			
			//Limpa toda a tabela
			priceRepository.deleteAll();
			
			
			//Persiste os dados em banco
			for (int i = 0; i < priceDTOToSave.size(); i++) {
				
				priceRepository.save(convertDTOToPrice(priceDTOToSave.get(i)));

			}
			
			

		} else {

			throw new RuntimeException("ERRO! As colunas da tabela possuem tamanhaos diferentes");
		}

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

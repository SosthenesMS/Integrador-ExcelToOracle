package com.pneubras.integrador.exceltooracle.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pneubras.integrador.exceltooracle.DTO.TblPrecoControladoriaComercialDTO;
import com.pneubras.integrador.exceltooracle.Entities.Excel.PlanilhaPrecoControladoriaComercial;
import com.pneubras.integrador.exceltooracle.Entities.Oracle.TblPrecoControladoriaComercial;
import com.pneubras.integrador.exceltooracle.Repositories.TblPrecoControladoriaComercialRepository;

@Service
public class TblPrecoControladoriaComercialService {

	@Autowired
	private TblPrecoControladoriaComercialRepository priceRepository;
	


	// Método para criar uma lista com vários obejtos únicos de PriceDTO
	public void convertPlanilhaExcelPriceToPriceDTOList(PlanilhaPrecoControladoriaComercial excelPrice) {

		List<Integer> codProdList = excelPrice.getCodProd();
		List<Double> priceList = excelPrice.getVlrVendaNovo();
		List<Integer> codTabList = excelPrice.getNuTab();

		List<TblPrecoControladoriaComercialDTO> priceDTOToSave = new ArrayList<>();

		if (codProdList.size() == priceList.size() && priceList.size() == codTabList.size()) {

			for (int i = 0; i < codProdList.size(); i++) {

				TblPrecoControladoriaComercialDTO priceDto = new TblPrecoControladoriaComercialDTO();
				priceDto.setCodProd(codProdList.get(i));
				priceDto.setVlrVendaNovo(priceList.get(i));
				priceDto.setNuTab(codTabList.get(i));

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

	
	
	public TblPrecoControladoriaComercialDTO convertPriceToDTO(TblPrecoControladoriaComercial price) {
		TblPrecoControladoriaComercialDTO priceDto = new TblPrecoControladoriaComercialDTO();
		priceDto.setCodId(price.getCodId());
		priceDto.setCodProd(price.getCodProd());
		priceDto.setNuTab(price.getNuTab());
		priceDto.setVlrVendaNovo(price.getVlrVendaNovo());
		return priceDto;
	}

	
	public TblPrecoControladoriaComercial convertDTOToPrice(TblPrecoControladoriaComercialDTO priceDto) {
		TblPrecoControladoriaComercial price = new TblPrecoControladoriaComercial();
		price.setCodId(priceDto.getCodId());
		price.setCodProd(priceDto.getCodProd());
		price.setNuTab(priceDto.getNuTab());
		price.setVlrVendaNovo(priceDto.getVlrVendaNovo());
		return price;
	}

}

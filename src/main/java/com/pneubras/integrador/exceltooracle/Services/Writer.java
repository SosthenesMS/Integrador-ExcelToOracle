package com.pneubras.integrador.exceltooracle.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.pneubras.integrador.exceltooracle.Entities.Excel.PlanilhaPrecoControladoriaComercial;


@Service
public class Writer {

	@Autowired
	private TblPrecoControladoriaComercialService priceService;
	
	@Autowired
	private Reader reader;
	
	@Autowired
	private Input input;
	
	
	public String savePriceDataToOracle() {
		
		String dataAtual = input.dataAtualLog();
		
		try {
			
			PlanilhaPrecoControladoriaComercial dadoExcel = reader.obterDadosDaPlanilhaPreco();
			System.out.println("Dados encontrados ********************--> " +  dataAtual);
			
			
			System.out.println("Salvando os dados no banco ********************--> " +  dataAtual);
			priceService.convertPlanilhaExcelPriceToPriceDTOList(dadoExcel);
			return "";
			
		} catch(Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
		
	}
	
}

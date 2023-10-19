package com.pneubras.integrador.exceltooracle.DTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.pneubras.integrador.exceltooracle.Entities.Excel.PlanilhaExcelPrice;
import com.pneubras.integrador.exceltooracle.Services.PriceService;


@Component
public class Writer {

	@Autowired
	private PriceService priceService;
	
	@Autowired
	private Reader reader;
	
	@Autowired
	private Input input;
	
	
	public String savePriceDataToOracle() {
		
		String dataAtual = input.dataAtualLog();
		
		try {
			
			PlanilhaExcelPrice dadoExcel = reader.obterDadosDaPlanilhaPreco();
			System.out.println("Dados encontrados ********************--> " +  dataAtual);
			
			
			System.out.println("Salvando os dados no banco ********************--> " +  dataAtual);
			priceService.convertPlanilhaExcelPriceToPriceDTOList(dadoExcel);
			return "";
			
		} catch(Exception ex) {
			throw new RuntimeException("Erro na leitura dos dados da planilha!");
		}
		
	}
	
}

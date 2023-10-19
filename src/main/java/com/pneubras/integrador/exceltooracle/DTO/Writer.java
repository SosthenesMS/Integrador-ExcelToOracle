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
	
	
	public String savePriceDataToOracle() {
		
		System.out.println("*****Cheguei no writer*****");
		
		try {
			PlanilhaExcelPrice dadoExcel = reader.obterDadosDaPlanilhaPreco();
			
			String retorno = priceService.saveDadosExcelToPriceDTO(dadoExcel);
			return retorno;
			
		} catch(Exception ex) {
			throw new RuntimeException("Erro na leitura dos dados da planilha!");
		}
		
	}
	
}

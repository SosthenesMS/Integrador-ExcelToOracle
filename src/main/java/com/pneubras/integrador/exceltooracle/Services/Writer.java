package com.pneubras.integrador.exceltooracle.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.pneubras.integrador.exceltooracle.Entities.Excel.PriceSheetControladoriaComercial;


@Service
public class Writer {

	@Autowired
	private PriceControladoriaComercialService priceService;
	
	@Autowired
	private Reader reader;
	
	@Autowired
	private Input input;
	
	
	public void savePriceDataToOracle() {
		String dataAtual = input.dataAtualLog();
		
		
		try {
			
			//FAZ A LEITURA DOS DADOS NA PLANILHA DO EXCEL - CHAMA A CLASSE READER
			PriceSheetControladoriaComercial excelData = reader.getDataFromPriceSheet();
			System.out.println("Dados compilados ************************************************** --> " +  dataAtual);
			
			
			System.out.println("Salvando os dados no banco **************************************** --> " +  dataAtual);
			//SALVA OS DADOS NO BANCO ORACLE - CHAMA A CLASSE SERVICE
			priceService.convertAndSaveDataToOracle(excelData);
			
			
		} catch(Exception ex) {
			
			throw new RuntimeException(ex.getMessage());
			
		}
		
	}
	
}

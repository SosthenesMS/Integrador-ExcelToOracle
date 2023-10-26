package com.pneubras.integrador.exceltooracle.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pneubras.integrador.exceltooracle.Services.Input;
import com.pneubras.integrador.exceltooracle.Services.Writer;

@RestController
public class PriceControladoriaComercialController {

	@Autowired
	private Writer writer;

	@Autowired
	private Input input;

	public void savePriceController() {

		String dataAtual = input.dataAtualLog();
		System.out.println("Iniciando o controller ******************************************** --> " + dataAtual);
		
		// CHAMA A CLASSE WRITER
		writer.savePriceDataToOracle();

	}

}

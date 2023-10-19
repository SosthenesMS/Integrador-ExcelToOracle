package com.pneubras.integrador.exceltooracle.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pneubras.integrador.exceltooracle.DTO.Input;
import com.pneubras.integrador.exceltooracle.DTO.Writer;
import com.pneubras.integrador.exceltooracle.Services.PriceService;


@RestController
public class PriceController {
	
	@Autowired
	private Writer writer;
	
	
	@Autowired
	private Input input;
	
	public String savePriceDataToOracle() {
		String dataAtual = input.dataAtualLog();
		System.out.println("Iniciando o controlador ********************--> " + dataAtual);
		String retorno = writer.savePriceDataToOracle();
		return retorno;
		
	}
	
}

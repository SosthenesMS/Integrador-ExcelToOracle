package com.pneubras.integrador.exceltooracle.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.pneubras.integrador.exceltooracle.Services.Input;
import com.pneubras.integrador.exceltooracle.Services.TblPrecoControladoriaComercialService;
import com.pneubras.integrador.exceltooracle.Services.Writer;


@RestController
public class TblPrecoControladoriaComercialController {
	
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

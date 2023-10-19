package com.pneubras.integrador.exceltooracle.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pneubras.integrador.exceltooracle.DTO.Writer;
import com.pneubras.integrador.exceltooracle.Services.PriceService;


@RestController
public class PriceController {
	
	@Autowired
	private Writer writer;
	
	
	public String savePriceDataToOracle() {
		System.out.println("*****Cheguei no controller*****");
		String retorno = writer.savePriceDataToOracle();
		return retorno;
		
	}
	
}

package com.pneubras.integrador.exceltooracle.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.pneubras.integrador.exceltooracle.Services.Input;
import com.pneubras.integrador.exceltooracle.Services.Writer;


@RestController
public class TblPrecoControladoriaComercialController {

	@Autowired
	private Writer writer;

	@Autowired
	private Input input;

	public void savePriceDataToOracle() {
		String dataAtual = input.dataAtualLog();

		Boolean checker = false;
		while (!checker) {

			try {
				System.out.println("Iniciando o controlador ********************--> " + dataAtual);
				writer.savePriceDataToOracle();
				checker = true;

			} catch (Exception ex ) {
				
				System.out.println("Erro ao tentar buscar a planilha -> " + ex.getMessage());
				checker = false;
			
			}

		}
	}

}

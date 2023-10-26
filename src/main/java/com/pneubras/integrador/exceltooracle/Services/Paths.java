package com.pneubras.integrador.exceltooracle.Services;

import org.springframework.stereotype.Service;

/*
 * CLASSE ESPECÍFICA PARA DEFINIÇÃO DOS CAMINHOS DOS ARQUIVOS
 * PARA CADA NOVA PLANILHA DEVERÁ SER CRIADO UM NOVO ATRIBUTO COM O NOVO ENDERECO QUE SERÁ UTILIZADO PELA CLASSE READER
 * 
 * */


@Service
public class Paths {

	private String controladoriaComercial = "../IntegradorExcelToOracle/src/main/resources/static/";
	
	private String controladoriaComercialRede = "/data/";
	
	
	
	public String getControladoriaComercialRede() {
		return controladoriaComercialRede;
	}



	public String getControladoriaComercial() {
		return controladoriaComercial;
	}

	
	
}

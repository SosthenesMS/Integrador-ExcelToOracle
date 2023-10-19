package com.pneubras.integrador.exceltooracle.DTO;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Input {
	
	//Construtor padrão
	public Input() {
		
	}

	
	public FileInputStream getInputStream(String localArquivo) {
		
		String nomePlanilha = dateOfDay();
		File file = new File(localArquivo + nomePlanilha );
		
		try {
			FileInputStream planilha = new FileInputStream(file);
			return planilha;
		} catch(Exception ex) {
			throw new RuntimeException("Planila de excel não localizada! Por favor verifique o caminho e a extenção do arquivo (.xls)");
		}
	}

	
	public String dateOfDay() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime time = LocalDateTime.now();
		String data = (time.format(format)) + ".xls";
		return data;
	}
	
	
}




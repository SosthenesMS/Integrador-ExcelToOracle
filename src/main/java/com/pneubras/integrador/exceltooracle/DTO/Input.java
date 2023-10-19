package com.pneubras.integrador.exceltooracle.DTO;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class Input {
	
	//Construtor padrão
	public Input() {
		
	}

	
	public FileInputStream getInputStream(String localArquivo) {
		
		String dataAtutal = dataAtualLog();
		System.out.println("Validando Nome da Planilha de acordo com a data do dia ********************--> " +  dataAtutal);
		
		String nomePlanilha = dateOfDay() +  ".xls";
		File file = new File(localArquivo + nomePlanilha);
		
		try {
			FileInputStream planilha = new FileInputStream(file);
			return planilha;
		} catch(Exception ex) {
			throw new RuntimeException("Planila de excel não localizada! Por favor verifique o caminho, o nome e a extenção do arquivo (.xls)");
		}
	}

	
	public String dateOfDay() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime time = LocalDateTime.now();
		String data = (time.format(format));
		return data;
	}
	
	public String dataAtualLog() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime data = LocalDateTime.now();
		String dataAtual = data.format(format);
		return dataAtual;
	}
	
	
}




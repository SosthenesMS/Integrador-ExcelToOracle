package com.pneubras.integrador.exceltooracle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.format.annotation.DateTimeFormat;

import com.pneubras.integrador.exceltooracle.Controllers.TblPrecoControladoriaComercialController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class IntegradorExcelToOracleApplication {
	
	@Autowired
	TblPrecoControladoriaComercialController priceController;

	public static void main(String[] args) {
		SpringApplication.run(IntegradorExcelToOracleApplication.class, args);
		
	}
	
	
	@PostConstruct
	public void init() {
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			
			
			
			@Override
			public void run() {
				
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
				LocalDateTime data = LocalDateTime.now();
				String dataAtual = data.format(format);
				
				try {
					System.out.println("Iniciando atualização da tabela de PREÇO ********************--> " + dataAtual );
					priceController.savePriceDataToOracle();
					
					System.out.println("Atualização da tabela de PREÇO finalizada ********************--> " + dataAtual );
					
				} catch(Exception ex) {
					System.out.println("Erro no controller! StackTtrace ********************--> " + ex.getMessage());
				}

			}

		}, 0,1 * 60 * 1000); // Executa a cada 4 horas
		//}, 0,1 * 60 * 1000); // Executa a cada 1 minuto
		//}, 0,10 * 60 * 1000); // Executa a cada 10 minutos 
	    //}, 0,30 * 60 * 1000); // Executa a cada 30 minutos 
		
	}
	

}

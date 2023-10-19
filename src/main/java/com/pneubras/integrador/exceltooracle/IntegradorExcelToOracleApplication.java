package com.pneubras.integrador.exceltooracle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pneubras.integrador.exceltooracle.Controllers.PriceController;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class IntegradorExcelToOracleApplication {
	
	@Autowired
	PriceController priceController;

	public static void main(String[] args) {
		SpringApplication.run(IntegradorExcelToOracleApplication.class, args);
		
	}
	
	
	@PostConstruct
	public void init() {
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
			
			@Override
			public void run() {
				
				try {
					priceController.savePriceDataToOracle();
				} catch(Exception ex) {
					System.out.println("*****Cheguei no main*****");
					System.out.println("Erro no controller! StackTtrace --> " + ex.getMessage());
				}

			}

		}, 0,2 * 60 * 1000); // Executa a cada 4 horas
		//}, 0,1 * 60 * 1000); // Executa a cada 1 minuto
		//}, 0,10 * 60 * 1000); // Executa a cada 10 minutos 
	    //}, 0,30 * 60 * 1000); // Executa a cada 30 minutos 
		
	}
	

}

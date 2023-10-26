package com.pneubras.integrador.exceltooracle;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.pneubras.integrador.exceltooracle.Controllers.PriceControladoriaComercialController;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class IntegradorExcelToOracleApplication {

	@Autowired
	PriceControladoriaComercialController priceController;

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
					
					System.out.println("******************** INICIANDO INTEGRADOR DE DADOS DO EXCEL ***************************** --> " + dataAtual + "\n");
					
					priceController.savePriceController();

					System.out.println("******************** LOOP DO INTEGRADOR DE DADOS DO EXCEL FINALIZADO ******************** --> " + dataAtual + "\n");

				} catch (Exception ex) {
					
					System.out.println("Exception na classe Main! StackTtrace ********************--> " + ex.getMessage());
				}

			}

		}, 0, 1 * 60 * 1000); // Executa a cada 4 horas
		// }, 0,1 * 60 * 1000); // Executa a cada 1 minuto
		// }, 0,10 * 60 * 1000); // Executa a cada 10 minutos
		// }, 0,30 * 60 * 1000); // Executa a cada 30 minutos

	}

}

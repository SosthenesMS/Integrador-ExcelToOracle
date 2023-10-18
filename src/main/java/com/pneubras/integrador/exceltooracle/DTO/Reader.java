package com.pneubras.integrador.exceltooracle.DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.pneubras.integrador.exceltooracle.Entities.PlanilhaPrice;


public class Reader {

	
	public void obterDadosDaPlanilhaPreco() throws IOException {
		
		PlanilhaPrice planilhaPrice = new PlanilhaPrice();
		String nomePlanilha = dateOfDay();
		
		//Criação do file contendo o caminho específico do arquivo
		File file = new File("C:\\Workspace\\Integrador-ExcelToOracle\\src\\main\\resources\\static\\" + nomePlanilha );
		
		
		////Criação do FileInputStream para ler o arquivo xls
		FileInputStream planilha = new FileInputStream(file);
		
		
		//Criando um HSSFWorkbook para acessar o arquivo excel
		HSSFWorkbook workbook = new HSSFWorkbook(planilha);
		
		
		//Definindo a aba que o java irá ler dento da planilha de excel
		HSSFSheet sheet = workbook.getSheetAt(1);
		
		
		//Definindo a linha que será lida pelo java
		HSSFRow row = sheet.getRow(0);
		
		//Definindo a celula que será lida
		HSSFCell cell = row.getCell(2);
		
	}
	
	
	
	
	public String dateOfDay() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime time = LocalDateTime.now();
		String data = (time.format(format)) + ".xls";
		return data;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

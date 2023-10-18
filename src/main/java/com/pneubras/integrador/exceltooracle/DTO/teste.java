package com.pneubras.integrador.exceltooracle.DTO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.pneubras.integrador.exceltooracle.Entities.PlanilhaPrice;

public class teste {

	static Integer linha = 0;
	static Integer colunaA = 0;
	static Integer colunaB = 1;
	static Integer colunaC = 2;
	static Integer colunaD = 3;
	static Integer colunaE = 4;

	public static void main(String[] args) throws IOException {
		

		//PlanilhaPrice planilhaPrice
		List<Double> planilhaList = new ArrayList<>();
		

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime time = LocalDateTime.now();
		String data = (time.format(format)) + ".xls";

		File file = new File("C:\\Workspace\\Integrador-ExcelToOracle\\src\\main\\resources\\static\\" + data);
		String fileName = file.getName();

		//// Criação do FileInputStream para ler o arquivo xls
		FileInputStream planilha = new FileInputStream(file);

		// Criando um HSSFWorkbook para acessar o arquivo excel
		HSSFWorkbook workbook = new HSSFWorkbook(planilha);

		// Definindo a aba que o java irá ler dento da planilha de excel
		HSSFSheet sheet = workbook.getSheetAt(1);

		// Definindo a linha que será lida pelo java
		HSSFRow row = sheet.getRow(linha);
		// Definindo a celula que será lida
		HSSFCell coluna = row.getCell(colunaA);
		var numberOfRows = sheet.getPhysicalNumberOfRows();
		
		for(int i = 0; i <= numberOfRows - 1; i++) {
			HSSFCell codProd = row.getCell(i);
			var codProdF = codProd.getNumericCellValue();
			planilhaList.add(codProdF);
		}
		
		System.out.println(planilhaList.toString());
		
		
		/*
		var teste = sheet.getFirstRowNum();
		var coluna = sheet.getColumnBreaks();
		var colunas = sheet.getColumnOutlineLevel(1);
		var colunaBrak = sheet.getColumnBreaks();
		var codProdF = codProdO.getStringCellValue();
		System.out.println("O valor achado é esse --> " + codProdF);
		System.out.println(data);
		System.out.println(fileName);
		System.out.println("coluna --> " + coluna);
		System.out.println("colunas --> " + colunas);
		System.out.println("colunaBrak --> " + colunaBrak);
		System.out.println("numberOfRows --> " + numberOfRows);
		System.out.println("teste --> " + teste);
		*/
		
		
		List<Integer> A = Arrays.asList(0,0);
		List<Integer> B = Arrays.asList(0,A.get(1)+1);
		List<Integer> C = Arrays.asList(0,B.get(1)+1);
		List<Integer> D = Arrays.asList(0,C.get(1)+1);
		List<Integer> E = Arrays.asList(0,D.get(1)+1);
		
		
		System.out.println("A -> " + A.toString() + "  B -> " + B.toString() + " C -> " + C.toString());
		

	}


}

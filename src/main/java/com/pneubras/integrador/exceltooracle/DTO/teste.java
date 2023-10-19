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

import com.pneubras.integrador.exceltooracle.Entities.Excel.PlanilhaExcelPrice;
import com.pneubras.integrador.exceltooracle.Entities.Oracle.Price;



public class teste {

	static Integer linha = 0;
	static Integer colunaA = 0;
	static Integer colunaB = 1;
	static Integer colunaC = 2;
	static Integer colunaD = 3;
	static Integer colunaE = 4;
	static Integer posicaoCodProd = 0;
	static Integer posicaoPreco = 1;
	static Integer posicaoCodTab = 2;

	public Price obter() {

		Price price = new Price();

		return price;
	}

	public static PlanilhaExcelPrice obterDadosDaPlanilha() throws IOException {

		PlanilhaExcelPrice excelPrice = new PlanilhaExcelPrice();

		List<Integer> codProdList = new ArrayList<>();
		List<Double> precoList = new ArrayList<>();
		List<Double> codTabList = new ArrayList<>();

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime time = LocalDateTime.now();
		String data = (time.format(format)) + ".xls";

		File file = new File("..\\Integrador-ExcelToOracle\\src\\main\\resources\\static\\" + data);
		String fileName = file.getName();

		//// Criação do FileInputStream para ler o arquivo xls
		FileInputStream planilha = new FileInputStream(file);

		// Criando um HSSFWorkbook para acessar o arquivo excel
		HSSFWorkbook workbook = new HSSFWorkbook(planilha);

		// Definindo a aba que o java irá ler dento da planilha de excel
		HSSFSheet sheet = workbook.getSheetAt(0);

		// Definindo a linha que será lida pelo java
		HSSFRow row = sheet.getRow(1);
		// Definindo a celula que será lida
		HSSFCell coluna = row.getCell(colunaA);
		var numberOfRows = sheet.getPhysicalNumberOfRows();

		for (int i = 1; i <= numberOfRows - 1; i++) {
			HSSFRow rowProd = sheet.getRow(i);
			HSSFCell codProd = rowProd.getCell(posicaoCodProd);
			Integer codProdF = (int) codProd.getNumericCellValue();
			if (codProdF != 0) {
				codProdList.add(codProdF);
				excelPrice.setCodProd(codProdList);
			} else {
				continue;
			}

		}

		for (int i = 1; i <= numberOfRows - 1; i++) {
			HSSFRow rowProd = sheet.getRow(i);
			HSSFCell codProd = rowProd.getCell(posicaoPreco);
			double preco = codProd.getNumericCellValue();
			if (preco != 0) {
				precoList.add(preco);
				excelPrice.setPrice(precoList);
			} else {
				continue;
			}

		}

		for (int i = 1; i <= numberOfRows - 1; i++) {
			HSSFRow rowProd = sheet.getRow(i);
			HSSFCell codProd = rowProd.getCell(posicaoCodTab);
			double codTab = codProd.getNumericCellValue();
			if (codTab != 0) {
				codTabList.add(codTab);
				excelPrice.setCodTab(codTabList);
			} else {
				continue;
			}

		}

		System.out.println("numberOfRows --> " + numberOfRows);

		/*
		 * var teste = sheet.getFirstRowNum(); var coluna = sheet.getColumnBreaks(); var
		 * colunas = sheet.getColumnOutlineLevel(1); var colunaBrak =
		 * sheet.getColumnBreaks(); var codProdF = codProdO.getStringCellValue();
		 * System.out.println("O valor achado é esse --> " + codProdF);
		 * System.out.println(data); System.out.println(fileName);
		 * System.out.println("coluna --> " + coluna); System.out.println("colunas --> "
		 * + colunas); System.out.println("colunaBrak --> " + colunaBrak);
		 * 
		 * System.out.println("teste --> " + teste);
		 */

		List<Integer> A = Arrays.asList(0, 0);
		List<Integer> B = Arrays.asList(0, A.get(1) + 1);
		List<Integer> C = Arrays.asList(0, B.get(1) + 1);
		List<Integer> D = Arrays.asList(0, C.get(1) + 1);
		List<Integer> E = Arrays.asList(0, D.get(1) + 1);

		// System.out.println("A -> " + A.toString() + " B -> " + B.toString() + " C ->
		// " + C.toString());

		return excelPrice;

	}

	public static void main(String[] args) throws IOException {

		PlanilhaExcelPrice price = obterDadosDaPlanilha();

		System.out.println("CODPROD --> " + price.getCodProd());
		System.out.println("price --> " + price.getPrice());
		System.out.println("codTab --> " + price.getCodTab());

	}

}

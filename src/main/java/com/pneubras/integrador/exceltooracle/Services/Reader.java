package com.pneubras.integrador.exceltooracle.Services;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.pneubras.integrador.exceltooracle.Entities.Excel.PlanilhaPrecoControladoriaComercial;

@Service
public class Reader {
	
	@Autowired
	private Input inputStream;

	
	//Método exclusivo para a leitura da planilha de PRECO
	public PlanilhaPrecoControladoriaComercial obterDadosDaPlanilhaPreco() throws IOException {
		Integer colunaA = 0;
		
		Integer posicaoCodTab = 0;
		Integer posicaoCodProd = 1;
		Integer posicaoVlrVendaAtual = 2;
		
		String dataAtual = inputStream.dataAtualLog();
		PlanilhaPrecoControladoriaComercial excelPrice = new PlanilhaPrecoControladoriaComercial();
		
		List<Integer> codProdList = new ArrayList<>();
		List<Double> vlrVendaVendaAtualList = new ArrayList<>();
		List<Integer> codTabList = new ArrayList<>();
		
		
		System.out.println("Buscando planilha ********************--> " +  dataAtual);
		//Criação do fileInputStream contendo o caminho específico do arquivo através da classe "Input"
		FileInputStream planilha = inputStream.getInputStream("..\\Integrador-ExcelToOracle\\src\\main\\resources\\static\\");
		System.out.println("Planilha localizada ********************--> " +  dataAtual);
		
		//Criando um HSSFWorkbook para acessar o arquivo excel
		HSSFWorkbook workbook = new HSSFWorkbook(planilha);
		
		//Definindo a aba que o java irá ler dento da planilha de excel
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		//Definindo a linha que será lida pelo java
		HSSFRow row = sheet.getRow(0);
		
		//Definindo a celula que será lida
		HSSFCell coluna = row.getCell(colunaA);
		var numberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println("numberOfRows ********************--> " +  numberOfRows);
		//numberOfRows = 282;
		
		
		
		//CONTADOR DE CELULAS PREENCHIDAS NA COLUNA A
		int count = 0;
		for(int i = 1; i <= numberOfRows; i++) {

			HSSFRow rowFound = sheet.getRow(i);
			HSSFCell cellFound = rowFound.getCell(colunaA);
			
			if(cellFound != null) {
				count += 1;
			} else {
				break;
			}
		}
		
	
		
		System.out.println("Total de linhas numéricas encontradas na COLUNA A: " +  count + " ********************--> " + dataAtual);
		
		for(int i = 1; i <= count; i++) {
			HSSFRow rowCodTab = sheet.getRow(i);
			HSSFCell codTabExc = rowCodTab.getCell(posicaoCodTab);
			Integer codTab = (int) codTabExc.getNumericCellValue();
			codTabList.add(codTab);
			excelPrice.setCodTab(codTabList);

		}

		
		for(int i = 1; i <= count; i++) {
			HSSFRow rowCodProd = sheet.getRow(i);
			HSSFCell codProdExc = rowCodProd.getCell(posicaoCodProd);
			Integer codProd = (int) codProdExc.getNumericCellValue();
			if (codProd != 0) {
				codProdList.add(codProd);
				excelPrice.setCodProd(codProdList);
			} else {
				continue;
			}

		}
		
		

		for(int i = 1; i <= count; i++) {
			HSSFRow rowVlrVendaAtual = sheet.getRow(i);
			HSSFCell vlrVendaAtualExc = rowVlrVendaAtual.getCell(posicaoVlrVendaAtual);
			Double vlrVendaAtual = vlrVendaAtualExc.getNumericCellValue();
			if (vlrVendaAtual != 0) {
				vlrVendaVendaAtualList.add(vlrVendaAtual);
				excelPrice.setVlrVendaAtual(vlrVendaVendaAtualList);
			} else {
				continue;
			}

		}
		

		return excelPrice;
		
	}
	
	
	
	//Criação de outros métodos para leitura de outras planilhas
	
	
}

package com.pneubras.integrador.exceltooracle.Services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pneubras.integrador.exceltooracle.Entities.Excel.PlanilhaPrecoControladoriaComercial;


@Service
public class Reader {
	
	@Autowired
	private Input inputStream;

	
	//Método exclusivo para a leitura da planilha de PRECO
	public PlanilhaPrecoControladoriaComercial obterDadosDaPlanilhaPreco() throws IOException {
		Integer colunaA = 0;
		Integer colunaB = 1;
		Integer colunaC = 2;
		Integer posicaoCodTab = 0;
		Integer posicaoCodProd = 1;
		Integer posicaoVlrVendaAntigo = 2;
		Integer posicaoVlrVendaNovo = 3;
		
		String dataAtual = inputStream.dataAtualLog();
		PlanilhaPrecoControladoriaComercial excelPrice = new PlanilhaPrecoControladoriaComercial();
		List<Integer> codProdList = new ArrayList<>();
		List<Double> precoList = new ArrayList<>();
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
		
		
		
		for(int i = 1; i <= numberOfRows - 1; i++) {
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
		
		
		for(int i = 1; i <= excelPrice.getCodProd().size(); i++) {
			HSSFRow rowProd = sheet.getRow(i);
			HSSFCell codProd = rowProd.getCell(posicaoCodTab);
			Integer codTab = (int) codProd.getNumericCellValue();
			codTabList.add(codTab);
			excelPrice.setCodTab(codTabList);
		
		}
		
	

		for(int i = 1; i <= numberOfRows - 1; i++) {
			HSSFRow rowProd = sheet.getRow(i);
			HSSFCell codProd = rowProd.getCell(posicaoVlrVendaAntigo);
			double vlrAntigo = codProd.getNumericCellValue();
			if (vlrAntigo != 0) {
				precoList.add(vlrAntigo);
				excelPrice.setPrice(precoList);
			} else {
				continue;
			}

		}


		return excelPrice;
		
	}
	
	
	
	//Criação de outros métodos para leitura de outras planilhas
	
	
	
}

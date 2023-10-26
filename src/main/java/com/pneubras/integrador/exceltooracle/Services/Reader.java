package com.pneubras.integrador.exceltooracle.Services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pneubras.integrador.exceltooracle.Entities.Excel.PriceSheetControladoriaComercial;



@Service
public class Reader {

	@Autowired
	private Input inputStream;
	
	@Autowired
	private Paths path;

	
	// MÉTODO EXCLUSIVO PARA A LEITURA DA PLANILHA PREÇO
	public PriceSheetControladoriaComercial getDataFromPriceSheet() throws IOException {
		Integer posicaoNuTab = 1;
		Integer posicaoCodProd = 2;
		Integer posicaoVlrVendaNovo = 3;
		
		String dataAtual = inputStream.dataAtualLog();
		PriceSheetControladoriaComercial excelPrice = new PriceSheetControladoriaComercial(); //OBJETO QUE SERÁ RETORNADO NO MÉTODO

		List<Integer> codProdList = new ArrayList<>();
		List<Integer> nuTabList = new ArrayList<>();
		List<Double> vlrVendaVendaNovoList = new ArrayList<>();

		System.out.println("Buscando planilha ************************************************* --> " + dataAtual);
		
		
		// Criação do fileInputStream contendo o caminho específico do arquivo de PRECO da CONTROLADORIA através da classe "Input"
		FileInputStream planilha = inputStream.getInputStream(path.getControladoriaComercialRede());		
		System.out.println("Planilha validada ************************************************* --> " + dataAtual);


		// Criando um XSSFWorkbook para acessar o arquivo excel .xlsx
		Workbook workbook = new XSSFWorkbook(planilha);		

		// Definindo a aba que o java irá ler dento da planilha de excel
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);
		
		// Obtendo o número de linhas da planilha
        int rows = ((org.apache.poi.ss.usermodel.Sheet) sheet).getPhysicalNumberOfRows();
               

        
		System.out.println("Linhas numéricas encontradas na COLUNA A: " + rows + " ******************** --> " + dataAtual);

		for (int i = 1; i <= rows; i++) {
			
			Row rowNuTab = sheet.getRow(i);
			if (rowNuTab != null) {
				Cell cellTab = rowNuTab.getCell(posicaoNuTab);
				Integer nuTab = (int) cellTab.getNumericCellValue();
				nuTabList.add(nuTab);
				excelPrice.setNuTab(nuTabList);
			} else {
				break;
			}			

		}

		
		for (int i = 1; i <= rows; i++) {
			
			Row rowCodProd = sheet.getRow(i);
			if(rowCodProd != null) {
				Cell cellCodProd = rowCodProd.getCell(posicaoCodProd);
				Integer codProd = (int) cellCodProd.getNumericCellValue();			
				codProdList.add(codProd);
				excelPrice.setCodProd(codProdList);
			} else {
				break;
			}		

		}

		
		for (int i = 1; i <= rows; i++) {
			
			Row rowVlrVendaAtual = sheet.getRow(i);
			if(rowVlrVendaAtual != null) {
				Cell cellVlrVendaAtual = rowVlrVendaAtual.getCell(posicaoVlrVendaNovo);
				Double vlrVendaAtual = cellVlrVendaAtual.getNumericCellValue();
				vlrVendaVendaNovoList.add(vlrVendaAtual);
				excelPrice.setVlrVenda(vlrVendaVendaNovoList);
			} else {
				break;
			}			

		}

		return excelPrice;
	}
			
	
	
	

	// Criação de outros métodos para leitura de outras planilhas
	
	

}

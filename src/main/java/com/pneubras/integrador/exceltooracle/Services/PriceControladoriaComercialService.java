package com.pneubras.integrador.exceltooracle.Services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pneubras.integrador.exceltooracle.DTO.PriceControladoriaComercialDTO;
import com.pneubras.integrador.exceltooracle.Entities.Excel.PriceSheetControladoriaComercial;
import com.pneubras.integrador.exceltooracle.Entities.Oracle.PriceControladoriaComercial;
import com.pneubras.integrador.exceltooracle.Repositories.PriceControladoriaComercialRepository;
import jakarta.transaction.Transactional;


@Service
public class PriceControladoriaComercialService {

	@Autowired
	private PriceControladoriaComercialRepository priceRepository;
	
	
	@Autowired
	private Input input;

	
	
	@Transactional
	public void convertAndSaveDataToOracle(PriceSheetControladoriaComercial excel) {

		List<Integer> nuTabList = excel.getNuTab();
		List<Integer> codProdList = excel.getCodProd();
		List<Double> vlrVendaList = excel.getVlrVenda();
		List<PriceControladoriaComercialDTO> dtoToSave = new ArrayList<>();


			for (int i = 0; i < codProdList.size(); i++) {
				

				PriceControladoriaComercialDTO priceDto = new PriceControladoriaComercialDTO();
				
				priceDto.setNutab(nuTabList.get(i)); //DADOS DO EXCEL
				priceDto.setCodprod(codProdList.get(i)); //DADOS DO EXCEL
				priceDto.setVlrvenda(vlrVendaList.get(i)); //DADOS DO EXCEL
				
				priceDto.setCodlocal(0); //O CODLOCAL SEMPRE SERÁ 0 ZERO
				priceDto.setTipo("V"); //DADOS MANUAIS
				priceDto.setModbaseicms("O"); // DADOS MANUAIS
				
				//SALVA UMA LISTA DE OBJETOS ÚNICOS
				dtoToSave.add(priceDto);	
				
			}
			
			//REALIZA O INSERT NO BANCO
			insertToOracle(dtoToSave);

	}


	@Transactional
	public PriceControladoriaComercialDTO convertPriceToDTO(PriceControladoriaComercial price) {
		
		PriceControladoriaComercialDTO dto = new PriceControladoriaComercialDTO();
		dto.setNutab(price.getNutab());
		dto.setCodprod(price.getCodprod());
		dto.setCodlocal(price.getCodlocal());
		dto.setVlrvenda(price.getVlrvenda());
		dto.setTipo(price.getTipo());
		dto.setModbaseicms(price.getModbaseicms());
		return dto;
	}

	@Transactional
	public PriceControladoriaComercial convertDTOToPrice(PriceControladoriaComercialDTO dto) {
		
		PriceControladoriaComercial price = new PriceControladoriaComercial();
		price.setNutab(dto.getNutab());
		price.setCodprod(dto.getCodprod());
		price.setCodlocal(dto.getCodlocal());
		price.setVlrvenda(dto.getVlrvenda());
		price.setTipo(dto.getTipo());
		price.setModbaseicms(dto.getModbaseicms());
		return price;
	}
	
	
	
	@Transactional
	public void insertToOracle(List<PriceControladoriaComercialDTO> dtoToSave) {

			String dataAtual = input.dataAtualLog();
			System.out.println("Iniciando insert ************************************************** --> " + dataAtual);
		   
				for(PriceControladoriaComercialDTO dto: dtoToSave) {
					
					
					Integer nutab = dto.getNutab();
					Integer codprod = dto.getCodprod();
					Integer codlocal = dto.getCodlocal();
					double vlrvenda = dto.getVlrvenda();
					String tipo = dto.getTipo();
					String modbaseicms = dto.getModbaseicms();

					int exist =  priceRepository.exist(nutab, codprod);
		
					
					//VERIFICA SE O OBJETO JÁ EXISTE NO BANCO, CASO NÃO EXISTA SERÁ REALIZADO O INSERT 
					if (exist != 1 ) {
									
						try{
							priceRepository.insertToOracle(nutab, codprod, codlocal, vlrvenda, tipo, modbaseicms);
							
						} catch(Exception ex) {
							
							throw new RuntimeException("Exception no service ao tentar realizar o insert! Verifique os dados");
							
						}
																							
					}
				
				}
								
				System.out.println("Insert finalizado ************************************************* --> " + dataAtual + "\n");	
	}
	
	
}

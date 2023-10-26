package com.pneubras.integrador.exceltooracle.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pneubras.integrador.exceltooracle.Entities.Oracle.PriceControladoriaComercial;
import jakarta.transaction.Transactional;



@Repository
public interface PriceControladoriaComercialRepository extends JpaRepository<PriceControladoriaComercial, Integer>{

	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "INSERT INTO TGFEXC (NUTAB, CODPROD, CODLOCAL, VLRVENDA, TIPO, MODBASEICMS)"
			+ "VALUES(:nutab,:codprod,:codlocal,:vlrvenda,:tipo,:modbaseicms)")
	Integer insertToOracle(@Param("nutab") Integer nutab,@Param("codprod") Integer codprod,@Param("codlocal") Integer codlocal,@Param("vlrvenda") double vlrvenda,@Param("tipo") String tipo,@Param("modbaseicms") String modbaseicms );

	
	//MÉTODO PARA VERIFICAR A EXISTENCIA DO OBEJTO NO BANCO ANTES DE REALIZAR O INSERT
	@Query( nativeQuery = true, value = "SELECT COALESCE(SUM(1), 0) FROM TGFEXC WHERE  NUTAB = :nutab AND CODPROD =  :codprod")
	int exist(int nutab,int codprod);
	
	
	
	
}





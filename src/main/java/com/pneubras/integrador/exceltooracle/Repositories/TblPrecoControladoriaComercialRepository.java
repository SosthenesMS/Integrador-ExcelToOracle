package com.pneubras.integrador.exceltooracle.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pneubras.integrador.exceltooracle.Entities.Oracle.TblPrecoControladoriaComercial;


@Repository
public interface TblPrecoControladoriaComercialRepository extends JpaRepository<TblPrecoControladoriaComercial, Integer>{

}





package com.grupo.msc.reposito;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.grupo.msc.model.NotaFiscal;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long>{

	public NotaFiscal findByNumero(@Param("numero") String numero);
	
}

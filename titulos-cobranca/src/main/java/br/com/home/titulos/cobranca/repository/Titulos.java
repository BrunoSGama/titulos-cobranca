package br.com.home.titulos.cobranca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.home.titulos.cobranca.model.Titulo;

public interface Titulos extends JpaRepository<Titulo, Long> {
	
}

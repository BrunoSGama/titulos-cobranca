package br.com.home.titulos.cobranca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.home.titulos.cobranca.model.StatusTitulo;
import br.com.home.titulos.cobranca.model.Titulo;
import br.com.home.titulos.cobranca.repository.Titulos;

@Service
public class TituloService {

	@Autowired
	private Titulos titulos;
	
	public void salvar(Titulo titulo) {
		
		try {
			titulos.save(titulo);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");
		}
	}
	
	public void excluir(Long codigo) {
		titulos.delete(codigo);
	}

	public String receber(Long codigo) {
		
		Titulo titulo = titulos.findOne(codigo);
		titulo.setStatus(StatusTitulo.RECEBIDO);
		titulos.save(titulo);
		
		return StatusTitulo.RECEBIDO.getDescricao();
	}
}

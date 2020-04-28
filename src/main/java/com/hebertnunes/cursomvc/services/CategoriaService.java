package com.hebertnunes.cursomvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hebertnunes.cursomvc.domain.Categoria;
import com.hebertnunes.cursomvc.exceptions.ObjectNotFoundException;
import com.hebertnunes.cursomvc.repositores.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria buscar(Integer id) {
		Categoria categoria = categoriaRepository.findOne(id);
		
		if(categoria == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo " + Categoria.class.getName());
		}
		
		return categoria;
	}
}

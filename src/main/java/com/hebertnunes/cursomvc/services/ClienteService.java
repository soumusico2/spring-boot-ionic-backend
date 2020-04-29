package com.hebertnunes.cursomvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hebertnunes.cursomvc.domain.Cliente;
import com.hebertnunes.cursomvc.exceptions.ObjectNotFoundException;
import com.hebertnunes.cursomvc.repositores.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Integer id) {
		Cliente cliente = clienteRepository.findOne(id);
		
		if(cliente == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + id
					+ ", Tipo " + Cliente.class.getName());
		}
		
		return cliente;
	}
}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.Clientes;

@Service
public class CadastroClienteService {

	
	@Autowired
	private Clientes clientes;
	
	public void excluir(Long codigo) {
		clientes.delete(codigo);
			
	}

	public void salvar(Cliente cliente) {
		try {
		  clientes.save(cliente);   	
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("Formato de data inválido");   			
		}		
	}

	
	
}

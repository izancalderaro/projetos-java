package com.example.demo.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cliente;


public interface Clientes extends JpaRepository<Cliente, Long>{
	
   List<Cliente> findBynomeContaining(String nome);
   
}

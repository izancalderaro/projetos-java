package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Cliente;
import com.example.demo.repository.Clientes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private Clientes clientes;
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroCliente";
	}
	 
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Cliente cliente) {
		clientes.save(cliente);
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject("mensagem" , "Cliente adicionado com sucesso");
		return mv;
	}
	
	
	
}

package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Cliente;
import com.example.demo.model.Sexo;
import com.example.demo.repository.Clientes;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private static final String CADASTRO_VIEW = "CadastroCliente";
		
	@Autowired
	private Clientes clientes;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Cliente());
		return mv;
	}
	 
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@Validated Cliente cliente, Errors errors) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		if (errors.hasErrors()) {
			return mv;
		}
		
		clientes.save(cliente);
		mv.addObject("mensagem" , "Cliente adicionado com sucesso");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
            List<Cliente> todosClientes = clientes.findAll();
            ModelAndView mv = new ModelAndView("PesquisaClientes");
            mv.addObject("todosClientes", todosClientes);
            return mv;
		
	}
	
	@ModelAttribute("todosSexo")
	public List<Sexo> todosSexo(){
		return Arrays.asList(Sexo.values());
	}
	
	
}

package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Cliente;
import com.example.demo.model.Sexo;
/*import com.example.demo.repository.Clientes;*/
import com.example.demo.repository.filter.ClienteFiltro;
import com.example.demo.service.CadastroClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private static final String CADASTRO_VIEW = "CadastroCliente";
		
/*	@Autowired
	private Clientes clientes;*/
	
	@Autowired
	private CadastroClienteService cadastroClienteService;
	
	
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Cliente());
		return mv;
	}
	 
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Cliente cliente, Errors errors, RedirectAttributes redirectAttributes) {
				
		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
	    try {			
		   
	       cadastroClienteService.salvar(cliente);
		   redirectAttributes.addFlashAttribute("mensagem" , "Cliente adicionado com sucesso");
		   return  "redirect:/clientes/novo";
		   
	    } catch(IllegalArgumentException e){		  
		   
	       errors.rejectValue("dataNascimento", null, e.getMessage());
		   return CADASTRO_VIEW;
		   
	    }
	}
	
	@RequestMapping
	//public ModelAndView pesquisar(@RequestParam(defaultValue = "%") String descricao) {
	public ModelAndView pesquisar(@ModelAttribute("clienteFiltro") ClienteFiltro clienteFiltro) {
		
            List<Cliente> todosClientes = cadastroClienteService.filtrar(clienteFiltro);    
		
            ModelAndView mv = new ModelAndView("PesquisaClientes");
            mv.addObject("todosClientes", todosClientes);
            return mv;		
	}                                   
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Cliente cliente) {
		//Cliente cliente = clientes.findOne(codigo);
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(cliente);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes redirectattributes) {
		cadastroClienteService.excluir(codigo);
		redirectattributes.addFlashAttribute("mensagem","Cliente excluído com sucesso");
		return "redirect:/clientes";
	}
	
	@RequestMapping(value="/{codigo}/mudanca", method=RequestMethod.PUT)
	public @ResponseBody String mudanca(@PathVariable Long codigo) {
       return cadastroClienteService.mudanca(codigo);		
	}
	
	
	@ModelAttribute("todosSexo")
	public List<Sexo> todosSexo(){
		return Arrays.asList(Sexo.values());
	}
	
/*	@RequestMapping("/teste")
	public ModelAndView teste() {
        List<Cliente> todosClientes = clientes.findAll();
        ModelAndView mv = new ModelAndView("TesteModal");
        mv.addObject("todosClientes", todosClientes);
        return mv;
	}*/
	
	
}

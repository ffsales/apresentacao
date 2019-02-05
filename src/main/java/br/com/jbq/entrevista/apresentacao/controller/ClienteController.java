package br.com.jbq.entrevista.apresentacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.jbq.entrevista.apresentacao.business.ClienteBusiness;
import br.com.jbq.entrevista.apresentacao.model.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private ClienteBusiness clienteBusiness;
	
	@GetMapping("/clientes")
	public ModelAndView findAll() {
	
		List<Cliente> clientes = clienteBusiness.findAll();
		
		ModelAndView mv = new ModelAndView("/clientes");
		mv.addObject("cliente", clientes);
		return mv;
	}
	
	@GetMapping("/novo-cliente")
	public String novoCliente() {
		
		return "/cliente";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Cliente cliente) {
		
		clienteBusiness.salvar(cliente);
		return "/clientes";
	}
}

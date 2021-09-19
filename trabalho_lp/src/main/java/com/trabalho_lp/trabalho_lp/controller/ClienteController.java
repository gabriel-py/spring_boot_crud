package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trabalho_lp.trabalho_lp.model.cliente;
import com.trabalho_lp.trabalho_lp.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository er;
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String cad_cliente() {
		System.out.println("teste");
		return "cliente/formCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String cad_livro(cliente l) {
		er.save(l);
		return "redirect:cliente/formCliente";
	}
	
	@RequestMapping("/listarCliente")
	public String list_cliente() {
		return "cliente/listaCliente";
	}
	
	@RequestMapping("/atualizarCliente")
	public String atualiza_cliente() {
		return "cliente/atualizaCliente";
	}
	
	@RequestMapping("/deletarCliente")
	public String deleta_cliente() {
		return "cliente/deletaCliente";
	}
}

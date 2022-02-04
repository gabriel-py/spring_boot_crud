package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho_lp.trabalho_lp.model.Cliente;
import com.trabalho_lp.trabalho_lp.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository cr;

	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String cadCliente() {
		return "cliente/formCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String cadCliente(Cliente l) {
		cr.save(l);
		return "redirect:/listarCliente";
	}
	
	@RequestMapping("/listarCliente")
	public ModelAndView listCliente() {
		ModelAndView mv = new ModelAndView("cliente/listCliente");
		Iterable<Cliente> cl = cr.findAll();
		mv.addObject("clientes", cl);
		return mv;
	}
	
	@RequestMapping("/atualizarCliente")
	public ModelAndView atualizarCliente(@RequestParam("codigo") long codigo) {
		Cliente cliente = cr.findByCodigo(codigo);
		cr.delete(cliente);
		ModelAndView mv = new ModelAndView("cliente/updateCliente");
		mv.addObject("cliente", cliente);
		return mv;
	}
	
	@RequestMapping(value="/atualizarCliente", method=RequestMethod.POST)
	public String salvaAtualizacao(Cliente l) {
		cr.save(l);
		return "redirect:/listarCliente";
	}
	
	@RequestMapping("/deletarCliente")
	public String deletaCliente(@RequestParam("codigo") long codigo) {
		Cliente clientes = cr.findByCodigo(codigo);
		cr.delete(clientes);
		return "redirect:/listarCliente";
	}
}

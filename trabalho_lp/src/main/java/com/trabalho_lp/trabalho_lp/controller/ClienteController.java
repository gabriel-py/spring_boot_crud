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
	private ClienteRepository er;
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String cad_cliente() {
		return "cliente/formCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String cad_livro(Cliente l) {
		er.save(l);
		return "redirect:/listarCliente";
	}
	
	@RequestMapping("/listarCliente")
	public ModelAndView list_cliente() {
		ModelAndView mv = new ModelAndView("cliente/listCliente");
		Iterable<Cliente> cl = er.findAll();
		mv.addObject("clientes", cl);
		return mv;
	}
	
	@RequestMapping("/atualizarCliente")
	public ModelAndView atualizar_cliente(@RequestParam("codigo") long cod_cliente) {
		Iterable<Cliente> clientes = er.findAll();
		Cliente c1 = null;
		for(Cliente c: clientes){
			if(c.getCodigo()==cod_cliente) {
				c1 = c;
				er.delete(c);
				break;
			}
		}
		ModelAndView mv = new ModelAndView("cliente/updateCliente");
		mv.addObject("cliente", c1);
		return mv;
	}
	
	@RequestMapping(value="/atualizarCliente", method=RequestMethod.POST)
	public String salva_atualizacao(Cliente l) {
		er.save(l);
		return "redirect:/listarCliente";
	}
	
	@RequestMapping("/deletarCliente")
	public String deleta_cliente(@RequestParam("codigo") long codigo) {
		Iterable<Cliente> clientes = er.findAll();
		for(Cliente c: clientes){
			if(c.getCodigo()== codigo) {
				er.delete(c);
				break;
			}
		}
		return "redirect:/listarCliente";
	}
}

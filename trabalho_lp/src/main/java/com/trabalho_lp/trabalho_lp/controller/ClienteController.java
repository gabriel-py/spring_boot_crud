package com.trabalho_lp.trabalho_lp.controller;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.trabalho_lp.trabalho_lp.model.cliente;
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
	public String cad_livro(cliente l) {
		er.save(l);
		return "redirect:/listarCliente";
	}
	
	@RequestMapping("/listarCliente")
	public ModelAndView list_cliente() {
		ModelAndView mv = new ModelAndView("cliente/listCliente");
		Iterable<cliente> cl = er.findAll();
		mv.addObject("cliente", cl);
		return mv;
	}
	
	@RequestMapping("/atualizarCliente")
	public ModelAndView atualizar_cliente(@RequestParam("cod_cliente") int cod_cliente) {
		Iterable<cliente> clientes = er.findAll();
		cliente c1 = null;
		for(cliente c: clientes){
			if(c.getCod_cliente()==cod_cliente) {
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
	public String salva_atualizacao(cliente l) {
		er.save(l);
		return "redirect:/listarCliente";
	}
	
	@RequestMapping("/deletarCliente")
	public String deleta_cliente(@RequestParam("cod_cliente") int cod_cliente) {
		Iterable<cliente> clientes = er.findAll();
		for(cliente c: clientes){
			if(c.getCod_cliente()==cod_cliente) {
				er.delete(c);
				break;
			}
		}
		return "redirect:/listarCliente";
	}
}

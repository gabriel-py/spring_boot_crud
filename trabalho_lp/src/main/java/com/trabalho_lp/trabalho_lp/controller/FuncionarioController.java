package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho_lp.trabalho_lp.model.cliente;
import com.trabalho_lp.trabalho_lp.model.funcionario;
import com.trabalho_lp.trabalho_lp.repository.ClienteRepository;
import com.trabalho_lp.trabalho_lp.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository er;
	
	@RequestMapping(value="/cadastrarFuncionario", method=RequestMethod.GET)
	public String cad_funcionario() {
		return "funcionario/formFuncionario";
	}
	
	@RequestMapping(value="/cadastrarFuncionario", method=RequestMethod.POST)
	public String list_funcionario(funcionario f) {
		er.save(f);
		return "redirect:/listarFuncionario";
	}
	
	@RequestMapping("/listarFuncionario")
	public ModelAndView list_cliente() {
		
		ModelAndView mv = new ModelAndView("funcionario/listFuncionario");
		Iterable<funcionario> f1 = er.findAll();
		mv.addObject("funcionario", f1);
		return mv;
	}
	
	@RequestMapping("/atualizarFuncionario")
	public ModelAndView atualizar_cliente(@RequestParam("id_func") int id_func) {
		System.out.println(id_func);
		Iterable<funcionario> funcs = er.findAll();
		funcionario f1 = null;
		for(funcionario f: funcs){
			if(f.getId_func()==id_func) {
				f1 = f;
				er.delete(f);
				break;
			}
		}
		ModelAndView mv = new ModelAndView("funcionario/updateFuncionario");
		mv.addObject("funcionario", f1);
		return mv;
	}
	
	@RequestMapping(value="/atualizarFuncionario", method=RequestMethod.POST)
	public String salva_atualizacao(funcionario l) {
		er.save(l);
		return "redirect:/listarFuncionario";
	}
	
	@RequestMapping("/deletarFuncionario")
	public String deleta_cliente(@RequestParam("id_func") int id_func) {
		Iterable<funcionario> funcs = er.findAll();
		for(funcionario f: funcs){
			if(f.getId_func()==id_func) {
				er.delete(f);
				break;
			}
		}
		return "redirect:/listarFuncionario";
	}
}

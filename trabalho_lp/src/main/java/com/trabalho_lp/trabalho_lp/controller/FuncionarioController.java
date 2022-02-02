package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho_lp.trabalho_lp.model.Funcionario;
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
	public String list_funcionario(Funcionario f) {
		er.save(f);
		return "redirect:/listarFuncionario";
	}
	
	@RequestMapping("/listarFuncionario")
	public ModelAndView list_cliente() {
		
		ModelAndView mv = new ModelAndView("funcionario/listFuncionario");
		Iterable<Funcionario> f1 = er.findAll();
		mv.addObject("funcionarios", f1);
		return mv;
	}
	
	@RequestMapping("/atualizarFuncionario")
	public ModelAndView atualizar_cliente(@RequestParam("id") long id_func) {
		System.out.println(id_func);
		Iterable<Funcionario> funcs = er.findAll();
		Funcionario f1 = null;
		for(Funcionario f: funcs){
			if(f.getId()==id_func) {
				f1 = f;
				er.delete(f);
				break;
			}
		}
		ModelAndView mv = new ModelAndView("funcionario/updateFuncionario");
		mv.addObject("funcionarios", f1);
		return mv;
	}
	
	@RequestMapping(value="/atualizarFuncionario", method=RequestMethod.POST)
	public String salva_atualizacao(Funcionario l) {
		er.save(l);
		return "redirect:/listarFuncionario";
	}
	
	@RequestMapping("/deletarFuncionario")
	public String deleta_cliente(@RequestParam("id") int id_func) {
		Iterable<Funcionario> funcs = er.findAll();
		for(Funcionario f: funcs){
			if(f.getId()==id_func) {
				er.delete(f);
				break;
			}
		}
		return "redirect:/listarFuncionario";
	}
}

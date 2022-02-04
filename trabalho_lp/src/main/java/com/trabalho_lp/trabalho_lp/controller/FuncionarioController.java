package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho_lp.trabalho_lp.model.Funcionario;
import com.trabalho_lp.trabalho_lp.repository.FuncionarioRepository;

import javax.validation.Valid;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository fr;

	@RequestMapping(value="/cadastrarFuncionario", method=RequestMethod.GET)
	public String cadFuncionario() {
		return "funcionario/formFuncionario";
	}
	
	@RequestMapping(value="/cadastrarFuncionario", method=RequestMethod.POST)
	public String cadFuncionario(@Valid Funcionario funcionario, BindingResult result) {
		if(result.hasErrors()){
			return "redirect:/cadastrarEvento";
		}
		fr.save(funcionario);
		return "redirect:/listarFuncionario";
	}
	
	@RequestMapping("/listarFuncionario")
	public ModelAndView listFuncionario() {
		ModelAndView mv = new ModelAndView("funcionario/listFuncionario");
		Iterable<Funcionario> funcionarios = fr.findAll();
		mv.addObject("funcionarios", funcionarios);
		return mv;
	}
	
	@RequestMapping("/atualizarFuncionario")
	public ModelAndView atualizarFuncionario(@RequestParam("id") long id) {
		System.out.println(id);
		Funcionario funcionario = fr.findById(id);
		fr.delete(funcionario);
		ModelAndView mv = new ModelAndView("funcionario/updateFuncionario");
		mv.addObject("funcionario", funcionario);
		return mv;
	}
	
	@RequestMapping(value="/atualizarFuncionario", method=RequestMethod.POST)
	public String salvaAtualizacao(Funcionario l) {
		fr.save(l);
		return "redirect:/listarFuncionario";
	}
	
	@RequestMapping("/deletarFuncionario")
	public String deletaFuncionario(@RequestParam("id") long id) {
		Funcionario funcionario = fr.findById(id);
		fr.delete(funcionario);
		return "redirect:/listarFuncionario";
	}
}

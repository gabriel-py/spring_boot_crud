package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho_lp.trabalho_lp.model.funcionario;
import com.trabalho_lp.trabalho_lp.model.livro;
import com.trabalho_lp.trabalho_lp.repository.LivroRepository;

@Controller
public class LivroController {
	
	@Autowired
	private LivroRepository er;
	
	@RequestMapping(value="/cadastrarLivro", method=RequestMethod.GET)
	public String cad_livro() {
		return "livro/formLivro";
	}
	
	@RequestMapping(value="/cadastrarLivro", method=RequestMethod.POST)
	public String cad_livro(livro l){
		er.save(l);
		return "redirect:/listarLivro";
	}
	
	@RequestMapping("/listarLivro")
	public ModelAndView list_livro() {
		ModelAndView mv = new ModelAndView("livro/listLivro");
		Iterable<livro> f1 = er.findAll();
		mv.addObject("livro", f1);
		return mv;
	}
	
	@RequestMapping("/atualizarLivro")
	public ModelAndView atualizar_cliente(@RequestParam("cod_livro") int cod_livro) {
		System.out.println(cod_livro);
		Iterable<livro> livros = er.findAll();
		livro l1 = null;
		for(livro l: livros){
			if(l.getCod_livro()==cod_livro) {
				l1 = l;
				er.delete(l);
				break;
			}
		}
		ModelAndView mv = new ModelAndView("livro/updateLivro");
		mv.addObject("livro", l1);
		return mv;
	}
	
	@RequestMapping(value="/atualizarLivro", method=RequestMethod.POST)
	public String salva_atualizacao(livro l) {
		er.save(l);
		return "redirect:/listarLivro";
	}
	
	@RequestMapping("/deletarLivro")
	public String deleta_cliente(@RequestParam("cod_livro") int cod_livro) {
		Iterable<livro> livros = er.findAll();
		for(livro l: livros){
			if(l.getCod_livro()==cod_livro) {
				er.delete(l);
				break;
			}
		}
		return "redirect:/listarLivro";
	}
}

package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.trabalho_lp.trabalho_lp.model.Livro;
import com.trabalho_lp.trabalho_lp.repository.LivroRepository;

@Controller
public class LivroController {
	
	@Autowired
	private LivroRepository er;
	
	@RequestMapping(value="/cadastrarLivro", method=RequestMethod.GET)
	public String cadLivro() {
		return "livro/formLivro";
	}
	
	@RequestMapping(value="/cadastrarLivro", method=RequestMethod.POST)
	public String cadLivroPost(Livro l){
		er.save(l);
		return "redirect:/listarLivro";
	}
	
	@RequestMapping("/listarLivro")
	public ModelAndView listLivro() {
		ModelAndView mv = new ModelAndView("livro/listLivro");
		Iterable<Livro> f1 = er.findAll();
		mv.addObject("livro", f1);
		return mv;
	}
	
	@RequestMapping("/atualizarLivro")
	public ModelAndView atualizarLivro(@RequestParam("codigo") int codigo) {
		System.out.println(codigo);
		Iterable<Livro> livros = er.findAll();
		Livro l1 = null;
		for(Livro l: livros){
			if(l.getCodigo()== codigo) {
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
	public String salvaAtualizacao(Livro l) {
		er.save(l);
		return "redirect:/listarLivro";
	}
	
	@RequestMapping("/deletarLivro")
	public String deletaCliente(@RequestParam("codigo") int codigo) {
		Iterable<Livro> livros = er.findAll();
		for(Livro l: livros){
			if(l.getCodigo()== codigo) {
				er.delete(l);
				break;
			}
		}
		return "redirect:/listarLivro";
	}
}

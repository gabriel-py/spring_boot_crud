package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.trabalho_lp.trabalho_lp.model.livro;
import com.trabalho_lp.trabalho_lp.repository.LivroRepository;

@Controller
public class LivroController {
	
	@Autowired
	private LivroRepository er;
	
	@RequestMapping(value="/cadastrarLivro", method=RequestMethod.GET)
	public String cad_livro() {
		return "livro/FormLivro";
	}
	
	@RequestMapping(value="/cadastrarLivro", method=RequestMethod.POST)
	public String cad_livro(livro l) {
		er.save(l);
		return "redirect:livro/FormLivro";
	}
	
	@RequestMapping("/listarLivro")
	public String list_livro() {
		return "livro/ListLivro";
	}
	
	@RequestMapping("/atualizarLivro")
	public String atualiza_livro() {
		return "livro/atualizaLivro";
	}
	
	@RequestMapping("/deletarLivro")
	public String deleta_livro() {
		return "livro/deletaLivro";
	}
}

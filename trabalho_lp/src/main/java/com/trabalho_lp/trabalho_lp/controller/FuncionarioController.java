package com.trabalho_lp.trabalho_lp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FuncionarioController {

	@RequestMapping("/cadastrarFuncionario")
	public String cad_funcionario() {
		return "funcionario/formFuncionario";
	}
	
	@RequestMapping("/listarFuncionario")
	public String list_funcionario() {
		return "funcionario/listaFuncionario";
	}
	
	@RequestMapping("/atualizarFuncionario")
	public String atualiza_funcionario() {
		return "funcionario/atualizaFuncionario";
	}
	
	@RequestMapping("/deletarFuncionario")
	public String deleta_funcionario() {
		return "funcionario/deletaFuncionario";
	}
}

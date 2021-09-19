package com.trabalho_lp.trabalho_lp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class livro {
	
	@Id
	private String cod_livro;
	private String nome_livro;
	private float preco_livro;
	
	public float getPreco_livro() {
		return preco_livro;
	}
	
	public void setPreco_livro(float preco_livro) {
		this.preco_livro = preco_livro;
	}
	
	public String getCod_livro() {
		return cod_livro;
	}
	
	public void setCod_livro(String cod_livro) {
		this.cod_livro = cod_livro;
	}
	
	public String getNome_livro() {
		return nome_livro;
	}
	
	public void setNome_livro(String nome_livro) {
		this.nome_livro = nome_livro;
	}
}

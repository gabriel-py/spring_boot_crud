package com.trabalho_lp.trabalho_lp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue
	private long codigo;
	private String nome;
	private String dataNasc;
	private float rendaMedia;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public float getRendaMedia() {
		return rendaMedia;
	}

	public void setRendaMedia(float rendaMedia) {
		this.rendaMedia = rendaMedia;
	}
}

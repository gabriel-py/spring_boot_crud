package com.trabalho_lp.trabalho_lp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class cliente {
	
	@Id
	@GeneratedValue
	private int cod_cliente;
	private String nome_cliente;
	private Date dt_nasc_cliente;
	private float renda_media;
	
	public int getCod_cliente() {
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public Date getDt_nasc_cliente() {
		return dt_nasc_cliente;
	}
	public void setData_nasc_cliente(Date dt_nasc_cliente) {
		this.dt_nasc_cliente = dt_nasc_cliente;
	}
	public float getRenda_media() {
		return renda_media;
	}
	public void setRenda_media(float renda_media) {
		this.renda_media = renda_media;
	}
	
}

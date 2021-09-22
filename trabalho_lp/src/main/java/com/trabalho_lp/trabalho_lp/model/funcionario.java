package com.trabalho_lp.trabalho_lp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class funcionario {
	
	@Id
	@GeneratedValue
	private int id_func;
	private String nome_func;
	private Date dt_nasc_func;
	
	public int getId_func() {
		return id_func;
	}
	public void setId_func(int id_func) {
		this.id_func = id_func;
	}
	public String getNome_func() {
		return nome_func;
	}
	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}
	public Date getDt_nasc_func() {
		return dt_nasc_func;
	}
	public void setData_nasc_func(Date dt_nasc_func) {
		this.dt_nasc_func = dt_nasc_func;
	}
	
	
}

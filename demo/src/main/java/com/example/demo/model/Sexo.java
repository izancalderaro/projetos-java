package com.example.demo.model;

public enum Sexo {

	M("Masculino"),
	F("Feminino");
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
	Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	
}

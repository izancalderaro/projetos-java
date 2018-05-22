package com.example.demo.model;

public enum Sexo {

	M("Nível Superior - NS"),
	F("Nível Médio - NM");
	
	private String descricao;

	public String getDescricao() {
		return descricao;
	}
	
	Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	
}

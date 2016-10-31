package com.ifnc.model;

public enum RatingEnum {

	G("G"),
	PG("PG"),
	PG_13("PG-13"),
	R("R"),
	NC_17("NC-17");

	private String descricao;

	private RatingEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
	
	
}

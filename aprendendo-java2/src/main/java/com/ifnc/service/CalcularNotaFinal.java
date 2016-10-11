package com.ifnc.service;

@NotaFinal
public class CalcularNotaFinal implements Calculadora{

	@Override
	public float soma(float a, float b) {
		// TODO Auto-generated method stub
		return ((a+b)+a*2)/2;
	}

	@Override
	public float subtrair(float a, float b) {
		// TODO Auto-generated method stub
		return a-b;
	}

}

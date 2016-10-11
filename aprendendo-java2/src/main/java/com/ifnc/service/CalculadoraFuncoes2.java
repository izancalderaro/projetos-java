package com.ifnc.service;


import com.ifnc.util.CalculadoraReal;

@CalculadoraReal
public class CalculadoraFuncoes2 implements Calculadora{

	@Override
	public float soma(float a, float b) {
		// TODO Auto-generated method stub
		return (a+b)*2;
	}

	@Override
	public float subtrair(float a, float b) {
		// TODO Auto-generated method stub
		return a-b;
	}

}

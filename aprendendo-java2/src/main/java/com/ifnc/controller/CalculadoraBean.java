
package com.ifnc.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifnc.service.Calculadora;

@Named
@RequestScoped
public class CalculadoraBean {

	@Inject
	private Calculadora calculadora;

	private int a,b;
	
	private float resultado;
	
	@PostConstruct
	public void init() {
		a = 10;
		b = 0;
	}
	
	public void Calcular() {
		
		resultado = calculadora.soma(a, b);
		
		System.out.println(resultado);
	}

	
	public Calculadora getCalculadora() {
		return calculadora;
	}

		
	public void setCalculadora(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

		
	public float getResultado() {
		return resultado;
	}


	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

}

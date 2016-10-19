
package com.ifnc.controller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ifnc.service.Calculadora;
import com.ifnc.service.PesoDois;

@Named
@RequestScoped
public class CalculadoraBean {

	@Inject
	@PesoDois
	private Calculadora calculadora;

	private float a, b;

	private float resultado;

	@PostConstruct
	public void init() {
		a = 5;
		b = 2;
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

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getResultado() {
		return resultado;
	}

	public void setResultado(float resultado) {
		this.resultado = resultado;
	}
	
}

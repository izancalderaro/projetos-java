package com.example.demo.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotEmpty(message="Nome obrigatório")
	@Size(max=60, message="O nome pode ter somente 60 caracteres")	
	private String nome;
	
	@NotNull(message="Data de nascimento é obrigatoria")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)		
	private Date dataNascimento;
	
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@NotNull(message="Salario é obrigatório")
	@DecimalMin(value="0.01", message="Salário não pode ser menor que 0,01")
	@DecimalMax(value="9999999.99", message="Salário não pode ser maior que R$ 9.999.999,00")
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal salario;

	@Pattern(regexp = "^[\\w\\-]+(\\.[\\w\\-]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$", message="E-mail com formato incorreto.")	
	@NotEmpty(message="E-mail é obrigatório")
    //@Email(message="Informe um E-mail válido") //não exige ponto e a região para válidar o email Ex.: (teste@teste.br), somente (teste@teste)
	private String email;
	
	@Pattern(regexp = "\\(?\\b([0-9]{2})\\)?[-. ]?([0-9]{4})[-. ]?([0-9]{4})\\b", message="Telefone em formato incorreto")
	private String telefone; 
	
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	public boolean isMasculino() {
		return Sexo.M.equals(this.sexo);
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	
	
	
}

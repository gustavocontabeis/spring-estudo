package br.com.coder.spring.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

@Entity
public class Tarefa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tarefa_seq")
	@SequenceGenerator(name="tarefa_seq", initialValue=1000)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@NotNull
	@NumberFormat(pattern="#,##0.00")
	private BigDecimal valor;
	
	public Tarefa() {
		super();
	}
	
	public Tarefa(Long id, String nome, Tipo tipo, BigDecimal valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}

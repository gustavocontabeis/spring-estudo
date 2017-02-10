package br.com.coder.spring.entity;

public enum Tipo {
	
	MELHORIA(1, "Melhoria"),
	BUG(2, "Bug"),
	TESTE(3, "Teste");
	
	Long cod;
	String descricao;
	
	Tipo(long cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
}

package br.com.jbq.entrevista.apresentacao.model;

public enum Sexo {
	
	MASCULINO(1), FEMININO(2);
	
	Integer id;
	
	Sexo(Integer id) {
		this.id = id;
	}
}

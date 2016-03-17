package br.com.projeto.api.entity;
import java.util.List;

import com.google.common.collect.Lists;

public class Funcionario {
	
	private Long id_funcionario;
	private String nome_func;
	
	public static final String TABLE = "TABELA_FUNCIONARIOS";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	
	public Funcionario() {
	}
	
	public Funcionario(Long id, String nome) {
		this.setId_funcionario(id);
		this.setNome_func(nome);
	}

	public Long getId_funcionario() {
		return this.id_funcionario;
	}
	public void setId_funcionario(Long id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getNome_func() {
		return this.nome_func;
	}
	public void setNome_func(String nome_func) {
		this.nome_func = nome_func;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME};
	}
}
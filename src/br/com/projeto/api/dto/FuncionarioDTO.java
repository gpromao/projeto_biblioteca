package br.com.projeto.api.dto;

public class FuncionarioDTO{
	
	private Long id_funcionario;
	private String nome_func;
	
	public static final String TABLE = "TABELA_FUNCIONARIOS";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	
	public FuncionarioDTO() {
	}
	
	public FuncionarioDTO(Long id, String nome) {
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
	@Override
	public String toString() {
		return "Funcionario[" + this.id_funcionario + " - " + this.nome_func + "]";
	}
}
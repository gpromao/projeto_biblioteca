package br.com.projeto.api.dto;

public class ClienteDTO {
	
	private Long id_cliente;
	private String nome_cliente;
	private String endereco;
	private String nascimento;

	public ClienteDTO() {

	}

	public ClienteDTO(Long id, String nome, String endereco, String nascimento) {
		this.setId_cliente(id);
		this.setNome_cliente(nome);
		this.setEndereco(endereco);
		this.setNascimento(nascimento);
	}

	public Long getId_cliente() {
		return this.id_cliente;
	}
	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome_cliente() {
		return this.nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getEndereco() {
		return this.endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNascimento() {
		return this.nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	@Override
	public String toString() {
		return "Cliente[" + this.id_cliente + " - " + this.nome_cliente + "]";
	}
}
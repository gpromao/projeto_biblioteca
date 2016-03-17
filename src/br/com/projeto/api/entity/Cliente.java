package br.com.projeto.api.entity;
import java.util.List;
import com.google.common.collect.Lists;

public class Cliente {
	
	private Long id_cliente;
	private String nome_cliente;
	private String endereco;
	private String nascimento;
	
	public static final String TABLE = "TABELA_CLIENTES";
	public static final String COL_ID = "ID";
	public static final String COL_NOME = "NOME";
	public static final String COL_END = "ENDERECO";
	public static final String COL_NASC = "NASCIMENTO";
	
	public Cliente() {

	}

	public Cliente(Long id, String nome, String endereco, String nascimento) {
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

	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_NOME, COL_END, COL_NASC);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_NOME, COL_END, COL_NASC};
	}
	
}
package br.com.projeto.api.entity;
import java.util.List;
import com.google.common.collect.Lists;

public class Emprestimo {
	
	private Long id_emp;
	private Long livro_emp;
	private Long cliente_emp;
	private Long func_emp;
	private String data_entrada;
	private String data_devolucao;
	private String status;
	
	public static final String TABLE = "TABELA_EMPRESTIMOS";
	public static final String COL_ID = "ID";
	public static final String COL_LIVRO = "LIVRO";
	public static final String COL_CLIENTE = "CLIENTE";
	public static final String COL_FUNCIONARIO = "FUNCIONARIO";
	public static final String COL_ENTRADA = "ENTRADA";
	public static final String COL_DEVOLUCAO = "DEVOLUCAO";
	public static final String COL_STATUS = "STATUS";
	
	public Emprestimo() {
	}

	public Emprestimo(Long id, Livro livro_emp, Cliente cliente_emp, Funcionario func_emp, String data_entrada, String data_devolucao, String status) {
		this.setId_emp(id);
		this.setLivro_emp(livro_emp);
		this.setCliente_emp(cliente_emp);
		this.setFunc_emp(func_emp);
		this.setData_entrada(data_entrada);
		this.setData_devolucao(data_devolucao);
		this.setStatus(status);
		
	}

	public Long getId_emp() {
		return this.id_emp;
	}
	public void setId_emp(Long id_emp) {
		this.id_emp = id_emp;
	}

	public Livro getLivro_emp() {
		return this.livro_emp;
	}
	public void setLivro_emp(Livro livro_emp) {
		this.livro_emp = livro_emp;
	}

	public Cliente getCliente_emp() {
		return this.cliente_emp;
	}
	public void setCliente_emp(Cliente cliente_emp) {
		this.cliente_emp = cliente_emp;
	}

	public Funcionario getFunc_emp() {
		return this.func_emp;
	}
	public void setFunc_emp(Funcionario func_emp) {
		this.func_emp = func_emp;
	}

	public String getData_entrada() {
		return this.data_entrada;
	}
	public void setData_entrada(String data_entrada) {
		this.data_entrada = data_entrada;
	}
	
	public String getData_devolucao() {
		return this.data_devolucao;
	}
	public void setData_devolucao(String data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_LIVRO, COL_CLIENTE, COL_FUNCIONARIO, COL_ENTRADA, COL_DEVOLUCAO, COL_STATUS);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_LIVRO, COL_CLIENTE, COL_FUNCIONARIO, COL_ENTRADA, COL_DEVOLUCAO, COL_STATUS};
	}

	
}
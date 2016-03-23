package br.com.projeto.api.dto;

public class EmprestimoDTO {
	
	private Long id_emp;
	private Long livro_emp;
	private Long cliente_emp;
	private Long func_emp;
	private String data_entrada;
	private String data_devolucao;
	private String status;

	
	public EmprestimoDTO() {
	}

	public EmprestimoDTO(Long id, Long livro_emp, Long cliente_emp, Long func_emp, String data_entrada, String data_devolucao, String status) {
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

	public Long getLivro_emp() {
		return this.livro_emp;
	}
	public void setLivro_emp(Long livro_emp) {
		this.livro_emp = livro_emp;
	}

	public Long getCliente_emp() {
		return this.cliente_emp;
	}
	public void setCliente_emp(Long cliente_emp) {
		this.cliente_emp = cliente_emp;
	}

	public Long getFunc_emp() {
		return this.func_emp;
	}
	public void setFunc_emp(Long func_emp) {
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
	@Override
	public String toString() {
		return "Emprestimo[" + this.id_emp + " - " + this.livro_emp + " - " + this.cliente_emp + "]";
	}
}
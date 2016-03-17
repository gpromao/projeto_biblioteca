package br.com.projeto.api.entity;
import java.util.List;

import com.google.common.collect.Lists;

public class Livro {
	
	private Long id_livro;
	private String titulo;
	private String autor;
	private String genero;
	private String editora;
	private Long emp_id;
	
	public static final String TABLE = "TABELA_LIVROS";
	public static final String COL_ID = "ID";
	public static final String COL_TITULO = "TITULO";
	public static final String COL_AUTOR = "AUTOR";
	public static final String COL_GENERO = "GENERO";
	public static final String COL_EDITORA = "EDITORA";
	public static final String COL_EMPRESTIMO = "EMPRESTIMO";
	
	public Livro() {
	}
	
	public Livro(Long id, String titulo, String autor, String genero, String editora, Long emp_id) {
		this.setId_livro(id);
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setGenero(genero);
		this.setEditora(editora);
		this.setEmp_cliente(emp_id);
	}

	public Long getId_livro() {
		return this.id_livro;
	}
	public void setId_livro(Long id_livro) {
		this.id_livro = id_livro;
	}

	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return this.autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return this.genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEditora() {
		return this.editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}

	public Emprestimo getEmp_id() {
		return this.emp_cliente;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_cliente = emp_cliente;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_ID, COL_TITULO, COL_AUTOR, COL_GENERO, COL_EDITORA, COL_EMPRESTIMO);
	}
	public static String[] getColunasArray() {
		return new String[] { COL_ID, COL_TITULO, COL_AUTOR, COL_GENERO, COL_EDITORA, COL_EMPRESTIMO};
	}

}
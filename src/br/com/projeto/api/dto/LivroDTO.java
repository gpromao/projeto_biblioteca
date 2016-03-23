package br.com.projeto.api.dto;

public class LivroDTO {
	
	private Long id_livro;
	private String titulo;
	private String autor;
	private String genero;
	private String editora;
	private Long emp_id;

	
	public LivroDTO() {
	}
	
	public LivroDTO(Long id, String titulo, String autor, String genero, String editora, Long emp_id) {
		this.setId_livro(id);
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setGenero(genero);
		this.setEditora(editora);
		this.setEmp_id(emp_id);
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

	public Long getEmp_id() {
		return this.emp_id;
	}
	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}
	@Override
	public String toString() {
		return "Livro[" + this.id_livro + " - " + this.titulo + "]";
	}
}

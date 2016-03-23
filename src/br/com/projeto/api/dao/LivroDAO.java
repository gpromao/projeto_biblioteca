
package br.com.projeto.api.dao;

import java.util.List;

import br.com.projeto.api.entity.Livro;

public interface LivroDAO {

	Long save(Livro livro);

	void update(Livro livro);

	void delete(Long id);

	Livro findById(Long id);

	List<Livro> findAll();

}

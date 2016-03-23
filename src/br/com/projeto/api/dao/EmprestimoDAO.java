
package br.com.projeto.api.dao;

import java.util.List;

import br.com.projeto.api.entity.Emprestimo;

public interface EmprestimoDAO {

	Long save(Emprestimo emprestimo);

	void update(Emprestimo emprestimo);

	void delete(Long id);

	Emprestimo findById(Long id);

	List<Emprestimo> findAll();

}

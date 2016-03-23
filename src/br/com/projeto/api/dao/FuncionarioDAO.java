
package br.com.projeto.api.dao;

import java.util.List;

import br.com.projeto.api.entity.Funcionario;

public interface FuncionarioDAO {

	Long save(Funcionario funcionario);

	void update(Funcionario funcionario);

	void delete(Long id);

	Funcionario findById(Long id);

	List<Funcionario> findAll();

}

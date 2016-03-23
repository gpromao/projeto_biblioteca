
package br.com.projeto.api.dao;

import java.util.List;

import br.com.projeto.api.entity.Cliente;

public interface ClienteDAO {

	Long save(Cliente cliente);

	void update(Cliente cliente);

	void delete(Long id);

	Cliente findById(Long id);

	List<Cliente> findAll();

}

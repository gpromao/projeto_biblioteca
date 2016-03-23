
package br.com.projeto.test.dao;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.projeto.api.dao.ClienteDAO;
import br.com.projeto.api.entity.Cliente;
import br.com.projeto.test.commons.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClienteDAOTest extends TestBase {

	private ClienteDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(ClienteDAO.class);
	}

	@Test
	public void testSave1() {

	}

	@Test
	public void testSave() {
		Cliente cli_salvar = new Cliente();
		cli_salvar.setNome_cliente("carlos");
		cli_salvar.setEndereco("end_carlos");
		cli_salvar.setNascimento("nasc_carlos");

		Long id = this.dao.save(cli_salvar);

		Cliente cli_salvo = this.dao.findById(id);

		Assert.assertNotNull(cli_salvo);
		Assert.assertEquals("carlos", cli_salvo.getNome_cliente());
		Assert.assertEquals("end_carlos", cli_salvo.getEndereco());
		Assert.assertEquals("nasc_carlos", cli_salvo.getNascimento());
	}

	@Test
	public void testUpdate() {
		Cliente cli_salvar = new Cliente();
		cli_salvar.setNome_cliente("carlos");
		cli_salvar.setEndereco("end_carlos");
		cli_salvar.setNascimento("nasc_carlos");

		Long id = this.dao.save(cli_salvar);
		Cliente cli_atualizar = this.dao.findById(id);

		cli_atualizar.setNome_cliente("carlos oliveira");
		cli_atualizar.setEndereco("novo_end_carlos");
		cli_atualizar.setNascimento("nasc_carlos");

		this.dao.update(cli_atualizar);
		Cliente cli_atualizado = this.dao.findById(id);

		Assert.assertNotNull(cli_atualizado);
		Assert.assertEquals("carlos oliveira", cli_atualizado.getNome_cliente());
		Assert.assertEquals("novo_end_carlos", cli_atualizado.getEndereco());
		Assert.assertEquals("nasc_carlos", cli_atualizado.getNascimento());
	}

	@Test
	public void testDelete() {
		Cliente cli_salvar = new Cliente();
		cli_salvar.setNome_cliente("carlos");
		cli_salvar.setEndereco("end_carlos");
		cli_salvar.setNascimento("nasc_carlos");

		Long id = this.dao.save(cli_salvar);
		this.dao.delete(id);

		Cliente cli_deletado = this.dao.findById(id);

		Assert.assertNull(cli_deletado);
	}

	@Test
	public void testFindAll() {
		Cliente cli1 = new Cliente();
		cli1.setNome_cliente("usuario 1");
		cli1.setEndereco("endereco_1");
		cli1.setNascimento("nascimento_1");
		Cliente cli2 = new Cliente();
		cli2.setNome_cliente("usuario 2");
		cli2.setEndereco("endereco_2");
		cli1.setNascimento("nascimento_2");

		this.dao.save(cli1);
		this.dao.save(cli2);

		List<Cliente> encontrados = this.dao.findAll();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("usuario 1", encontrados.get(0).getNome_cliente());
		Assert.assertEquals("endereco_1", encontrados.get(0).getEndereco());
		Assert.assertEquals("nascimento_1", encontrados.get(0).getNascimento());
		Assert.assertEquals("usuario 2", encontrados.get(1).getNome_cliente());
		Assert.assertEquals("endereco_2", encontrados.get(1).getEndereco());
		Assert.assertEquals("nascimento_2", encontrados.get(1).getNascimento());
	}

}

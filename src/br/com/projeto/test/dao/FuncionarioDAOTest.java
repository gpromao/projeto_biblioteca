
package br.com.projeto.test.dao;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.projeto.api.dao.FuncionarioDAO;
import br.com.projeto.api.entity.Funcionario;
import br.com.projeto.test.commons.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class FuncionarioDAOTest extends TestBase {

	private FuncionarioDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(FuncionarioDAO.class);
	}

	@Test
	public void testSave1() {

	}

	@Test
	public void testSave() {
		Funcionario fun_salvar = new Funcionario();
		fun_salvar.setNome_func("patchouli");

		Long id = this.dao.save(fun_salvar);

		Funcionario fun_salvo = this.dao.findById(id);

		Assert.assertNotNull(fun_salvo);
		Assert.assertEquals("patchouli", fun_salvo.getNome_func());
	}

	@Test
	public void testUpdate() {
		Funcionario fun_salvar = new Funcionario();
		fun_salvar.setNome_func("patchouli");

		Long id = this.dao.save(fun_salvar);
		Funcionario fun_atualizar = this.dao.findById(id);

		fun_atualizar.setNome_func("patchouli knowledge");

		this.dao.update(fun_atualizar);
		Funcionario fun_atualizado = this.dao.findById(id);

		Assert.assertNotNull(fun_atualizado);
		Assert.assertEquals("patchouli knowledge", fun_atualizado.getNome_func());
	}

	@Test
	public void testDelete() {
		Funcionario fun_salvar = new Funcionario();
		fun_salvar.setNome_func("patchouli knowledge");

		Long id = this.dao.save(fun_salvar);
		this.dao.delete(id);

		Funcionario fun_deletado = this.dao.findById(id);

		Assert.assertNull(fun_deletado);
	}

	@Test
	public void testFindAll() {
		Funcionario fun1 = new Funcionario();
		fun1.setNome_func("patchouli knowledge");
		Funcionario fun2 = new Funcionario();
		fun2.setNome_func("koakuma");

		this.dao.save(fun1);
		this.dao.save(fun2);

		List<Funcionario> encontrados = this.dao.findAll();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("patchouli knowledge", encontrados.get(0).getNome_func());
		Assert.assertEquals("koakuma", encontrados.get(1).getNome_func());
	}

}

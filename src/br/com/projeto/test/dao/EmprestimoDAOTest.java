
package br.com.projeto.test.dao;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.projeto.api.dao.EmprestimoDAO;
import br.com.projeto.api.entity.Emprestimo;
import br.com.projeto.test.commons.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EmprestimoDAOTest extends TestBase {

	private EmprestimoDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(EmprestimoDAO.class);
	}

	@Test
	public void testSave1() {

	}

	@Test
	public void testSave() {
		Emprestimo emp_salvar = new Emprestimo();
		emp_salvar.setLivro_emp(null);
		emp_salvar.setCliente_emp(null);
		emp_salvar.setFunc_emp(null);
		emp_salvar.setData_entrada("10/01/16");
		emp_salvar.setData_devolucao("10/02/16");
		emp_salvar.setStatus("Encerrado");

		Long id = this.dao.save(emp_salvar);

		Emprestimo emp_salvo = this.dao.findById(id);

		Assert.assertNotNull(emp_salvo);
		Assert.assertEquals("10/01/16", emp_salvo.getData_entrada());
		Assert.assertEquals("10/02/16", emp_salvo.getData_devolucao());
		Assert.assertEquals("Encerrado", emp_salvo.getStatus());
	}

	@Test
	public void testUpdate() {
		Emprestimo emp_salvar = new Emprestimo();
		emp_salvar.setLivro_emp(null);
		emp_salvar.setCliente_emp(null);
		emp_salvar.setFunc_emp(null);
		emp_salvar.setData_entrada("10/01/16");
		emp_salvar.setData_devolucao("10/02/16");
		emp_salvar.setStatus("Encerrado");

		Long id = this.dao.save(emp_salvar);
		Emprestimo emp_atualizar = this.dao.findById(id);

		emp_atualizar.setData_entrada("25/01/16");
		emp_atualizar.setData_devolucao("25/04/16");
		emp_atualizar.setStatus("Ativo");

		this.dao.update(emp_atualizar);
		Emprestimo emp_atualizado = this.dao.findById(id);

		Assert.assertNotNull(emp_atualizado);
		Assert.assertEquals("25/01/16", emp_atualizado.getData_entrada());
		Assert.assertEquals("25/04/16", emp_atualizado.getData_devolucao());
		Assert.assertEquals("Ativo", emp_atualizado.getStatus());
	}

	@Test
	public void testDelete() {
		Emprestimo emp_salvar = new Emprestimo();
		emp_salvar.setLivro_emp(null);
		emp_salvar.setCliente_emp(null);
		emp_salvar.setFunc_emp(null);
		emp_salvar.setData_entrada("10/01/16");
		emp_salvar.setData_devolucao("10/02/16");
		emp_salvar.setStatus("Encerrado");

		Long id = this.dao.save(emp_salvar);
		this.dao.delete(id);

		Emprestimo emp_deletado = this.dao.findById(id);

		Assert.assertNull(emp_deletado);
	}

	@Test
	public void testFindAll() {
		Emprestimo emp1 = new Emprestimo();
		emp1.setData_entrada("10/01/16");
		emp1.setData_devolucao("10/02/16");
		emp1.setStatus("Encerrado");
		Emprestimo emp2 = new Emprestimo();
		emp2.setData_entrada("25/01/16");
		emp2.setData_devolucao("25/04/16");
		emp1.setStatus("Ativo");

		this.dao.save(emp1);
		this.dao.save(emp2);

		List<Emprestimo> encontrados = this.dao.findAll();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("usuario 1", encontrados.get(0).getData_entrada());
		Assert.assertEquals("endereco_1", encontrados.get(0).getData_devolucao());
		Assert.assertEquals("nascimento_1", encontrados.get(0).getStatus());
		Assert.assertEquals("usuario 2", encontrados.get(1).getData_entrada());
		Assert.assertEquals("endereco_2", encontrados.get(1).getData_devolucao());
		Assert.assertEquals("nascimento_2", encontrados.get(1).getStatus());
	}

}

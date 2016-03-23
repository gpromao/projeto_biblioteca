
package br.com.projeto.test.dao;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import org.junit.Assert;

import br.com.projeto.api.dao.LivroDAO;
import br.com.projeto.api.entity.Livro;
import br.com.projeto.test.commons.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class LivroDAOTest extends TestBase {

	private LivroDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(LivroDAO.class);
	}

	@Test
	public void testSave1() {

	}

	@Test
	public void testSave() {
		Livro livro_salvar = new Livro();
		livro_salvar.setTitulo("Arte da Guerra");
		livro_salvar.setAutor("Sun Tzu");
		livro_salvar.setGenero("Filosofia");
		livro_salvar.setEditora("Wei");
		livro_salvar.setEmp_id(null);

		Long id = this.dao.save(livro_salvar);

		Livro livro_salvo = this.dao.findById(id);

		Assert.assertNotNull(livro_salvo);
		Assert.assertEquals("Arte da Guerra", livro_salvo.getTitulo());
		Assert.assertEquals("Sun Tzu", livro_salvo.getAutor());
		Assert.assertEquals("Filosofia", livro_salvo.getGenero());
		Assert.assertEquals("Wei", livro_salvo.getEditora());
	}

	@Test
	public void testUpdate() {
		Livro livro_salvar = new Livro();
		livro_salvar.setTitulo("Arte da Guerra");
		livro_salvar.setAutor("Sun Tzu");
		livro_salvar.setGenero("Filosofia");
		livro_salvar.setEditora("Wu");
		livro_salvar.setEmp_id(null);

		Long id = this.dao.save(livro_salvar);
		Livro livro_atualizar = this.dao.findById(id);

		livro_atualizar.setTitulo("Arte da Guerra NEO");
		livro_atualizar.setAutor("Sima Yi");
		livro_atualizar.setGenero("Economia");
		livro_atualizar.setEditora("Wei");

		this.dao.update(livro_atualizar);
		Livro livro_atualizado = this.dao.findById(id);

		Assert.assertNotNull(livro_atualizado);
		Assert.assertEquals("Arte da Guerra NEO", livro_atualizado.getTitulo());
		Assert.assertEquals("Sima Yi", livro_atualizado.getAutor());
		Assert.assertEquals("Economia", livro_atualizado.getGenero());
		Assert.assertEquals("Wei", livro_atualizado.getEditora());
	}

	@Test
	public void testDelete() {
		Livro livro_salvar = new Livro();
		livro_salvar.setTitulo("Arte da Guerra");
		livro_salvar.setAutor("Sun Tzu");
		livro_salvar.setGenero("Filosofia");
		livro_salvar.setEditora("Wu");
		livro_salvar.setEmp_id(null);

		Long id = this.dao.save(livro_salvar);
		this.dao.delete(id);

		Livro livro_deletado = this.dao.findById(id);

		Assert.assertNull(livro_deletado);
	}

	@Test
	public void testFindAll() {
		Livro livro1 = new Livro();
		livro1.setTitulo("livro_1");
		livro1.setAutor("autor_1");
		livro1.setGenero("genero_1");
		livro1.setEditora("editora_1");
		Livro livro2 = new Livro();
		livro1.setTitulo("livro_2");
		livro1.setAutor("autor_2");
		livro1.setGenero("genero_2");
		livro1.setEditora("editora_2");

		this.dao.save(livro1);
		this.dao.save(livro2);

		List<Livro> encontrados = this.dao.findAll();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("livro_1", encontrados.get(0).getTitulo());
		Assert.assertEquals("autor_1", encontrados.get(0).getAutor());
		Assert.assertEquals("genero_1", encontrados.get(0).getGenero());
		Assert.assertEquals("editora_1", encontrados.get(0).getEditora());
		Assert.assertEquals("livro_2", encontrados.get(1).getTitulo());
		Assert.assertEquals("autor_2", encontrados.get(1).getAutor());
		Assert.assertEquals("genero_2", encontrados.get(1).getGenero());
		Assert.assertEquals("editora_2", encontrados.get(1).getEditora());
	}

}

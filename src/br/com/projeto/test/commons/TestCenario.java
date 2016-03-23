package br.com.projeto.test.commons;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import br.com.projeto.api.dao.ClienteDAO;
import br.com.projeto.api.dao.EmprestimoDAO;
import br.com.projeto.api.dao.FuncionarioDAO;
import br.com.projeto.api.dao.LivroDAO;
import br.com.projeto.api.dto.ClienteDTO;
import br.com.projeto.api.dto.EmprestimoDTO;
import br.com.projeto.api.dto.FuncionarioDTO;
import br.com.projeto.api.dto.LivroDTO;
import br.com.projeto.api.entity.Cliente;
import br.com.projeto.api.entity.Emprestimo;
import br.com.projeto.api.entity.Funcionario;
import br.com.projeto.api.entity.Livro;
import br.com.projeto.api.service.ClienteService;
import br.com.projeto.api.service.EmprestimoService;
import br.com.projeto.api.service.FuncionarioService;
import br.com.projeto.api.service.LivroService;
import br.com.projeto.core.converter.ClienteDTOConverter;
import br.com.projeto.core.converter.EmprestimoDTOConverter;
import br.com.projeto.core.converter.FuncionarioDTOConverter;
import br.com.projeto.core.converter.LivroDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public abstract class TestCenario extends TestBase {

	protected ClienteDAO clienteDAO;
	protected EmprestimoDAO emprestimoDAO;
	protected FuncionarioDAO funcionarioDAO;
	protected LivroDAO livroDAO;

	protected ClienteDTOConverter clienteConverter;
	protected EmprestimoDTOConverter emprestimoConverter;
	protected FuncionarioDTOConverter funcionarioConverter;
	protected LivroDTOConverter livroConverter;

	protected ClienteService clienteService;
	protected EmprestimoService emprestimoService;
	protected FuncionarioService funcionarioService;
	protected LivroService livroService;

	protected Map<Long, Cliente> clientes = Maps.newHashMap();
	protected Map<Long, Emprestimo> emprestimos = Maps.newHashMap();
	protected Map<Long, Funcionario> funcionarios = Maps.newHashMap();
	protected Map<Long, Livro> livros = Maps.newHashMap();

	protected Map<Long, ClienteDTO> clienteDtos = Maps.newHashMap();
	protected Map<Long, EmprestimoDTO> emprestimoDtos = Maps.newHashMap();
	protected Map<Long, FuncionarioDTO> funcionarioDtos = Maps.newHashMap();
	protected Map<Long, LivroDTO> livroDtos = Maps.newHashMap();

	@Before
	public void upCenario() {
		this.clienteDAO = ImplFinder.getImpl(ClienteDAO.class);
		this.emprestimoDAO = ImplFinder.getImpl(EmprestimoDAO.class);
		this.funcionarioDAO = ImplFinder.getImpl(FuncionarioDAO.class);
		this.livroDAO = ImplFinder.getImpl(LivroDAO.class);

		this.clienteConverter = ImplFinder.getFinalImpl(ClienteDTOConverter.class);
		this.emprestimoConverter = ImplFinder.getFinalImpl(EmprestimoDTOConverter.class);
		this.funcionarioConverter = ImplFinder.getFinalImpl(FuncionarioDTOConverter.class);
		this.livroConverter = ImplFinder.getFinalImpl(LivroDTOConverter.class);

		this.clienteService = ImplFinder.getImpl(ClienteService.class);
		this.emprestimoService = ImplFinder.getImpl(EmprestimoService.class);
		this.funcionarioService = ImplFinder.getImpl(FuncionarioService.class);
		this.livroService = ImplFinder.getImpl(LivroService.class);

		this.criarClientes();
		this.criarEmprestimos();
		this.criarFuncionarios();
		this.criarLivros();
	}

	@After
	public void downCenario() {
		this.clientes = Maps.newHashMap();
		this.emprestimos = Maps.newHashMap();
		this.funcionarios = Maps.newHashMap();
		this.livros = Maps.newHashMap();
	}

	// Criação de Cenários
	private void criarClientes() {
		Cliente u1 = new Cliente(null, "Carlos", "blah1", "poi1");
		Cliente u2 = new Cliente(null, "Augusto", "blah2", "poi2");
		Cliente u3 = new Cliente(null, "Argemiro", "blah3", "poi3");

		Long u1Id = this.clienteDAO.save(u1);
		this.clientes.put(u1Id, this.clienteDAO.findById(1l));
		Long u2Id = this.clienteDAO.save(u2);
		this.clientes.put(u2Id, this.clienteDAO.findById(2l));
		Long u3Id = this.clienteDAO.save(u3);
		this.clientes.put(u3Id, this.clienteDAO.findById(3l));

		this.clienteDtos.put(1l, this.clienteConverter.toDTO(this.clientes.get(1l)));
		this.clienteDtos.put(2l, this.clienteConverter.toDTO(this.clientes.get(2l)));
		this.clienteDtos.put(3l, this.clienteConverter.toDTO(this.clientes.get(3l)));
	}
	
	private void criarEmprestimos() {
		Emprestimo u1 = new Emprestimo(null, null, null, null, "10/03/16", "25/04/16", "Ativo");
		Emprestimo u2 = new Emprestimo(null, null, null, null, "11/03/16", "26/04/16", "Ativo");
		Emprestimo u3 = new Emprestimo(null, null, null, null, "12/03/16", "27/04/16", "Ativo");

		Long u1Id = this.emprestimoDAO.save(u1);
		this.emprestimos.put(u1Id, this.emprestimoDAO.findById(1l));
		Long u2Id = this.emprestimoDAO.save(u2);
		this.emprestimos.put(u2Id, this.emprestimoDAO.findById(2l));
		Long u3Id = this.emprestimoDAO.save(u3);
		this.emprestimos.put(u3Id, this.emprestimoDAO.findById(3l));

		this.emprestimoDtos.put(1l, this.emprestimoConverter.toDTO(this.emprestimos.get(1l)));
		this.emprestimoDtos.put(2l, this.emprestimoConverter.toDTO(this.emprestimos.get(2l)));
		this.emprestimoDtos.put(3l, this.emprestimoConverter.toDTO(this.emprestimos.get(3l)));
	}
	
	private void criarFuncionarios() {
		Funcionario u1 = new Funcionario(null, "Yukikaze");
		Funcionario u2 = new Funcionario(null, "Shimakaze");
		Funcionario u3 = new Funcionario(null, "Amatsukaze");

		Long u1Id = this.funcionarioDAO.save(u1);
		this.funcionarios.put(u1Id, this.funcionarioDAO.findById(1l));
		Long u2Id = this.funcionarioDAO.save(u2);
		this.funcionarios.put(u2Id, this.funcionarioDAO.findById(2l));
		Long u3Id = this.funcionarioDAO.save(u3);
		this.funcionarios.put(u3Id, this.funcionarioDAO.findById(3l));

		this.funcionarioDtos.put(1l, this.funcionarioConverter.toDTO(this.funcionarios.get(1l)));
		this.funcionarioDtos.put(2l, this.funcionarioConverter.toDTO(this.funcionarios.get(2l)));
		this.funcionarioDtos.put(3l, this.funcionarioConverter.toDTO(this.funcionarios.get(3l)));
	}
	
	private void criarLivros() {
		Livro u1 = new Livro(null, "Unthinkable Natural Law", "ZUN", "Fantasia", "Shangai Alice", null);
		Livro u2 = new Livro(null, "Embodiment of Scarlet Devil", "ZUN", "Fantasia", "Shangai Alice", null);
		Livro u3 = new Livro(null, "Double Dealing Character", "ZUN", "Fantasia", "Shangai Alice", null);

		Long u1Id = this.livroDAO.save(u1);
		this.livros.put(u1Id, this.livroDAO.findById(1l));
		Long u2Id = this.livroDAO.save(u2);
		this.livros.put(u2Id, this.livroDAO.findById(2l));
		Long u3Id = this.livroDAO.save(u3);
		this.livros.put(u3Id, this.livroDAO.findById(3l));

		this.clienteDtos.put(1l, this.clienteConverter.toDTO(this.clientes.get(1l)));
		this.clienteDtos.put(2l, this.clienteConverter.toDTO(this.clientes.get(2l)));
		this.clienteDtos.put(3l, this.clienteConverter.toDTO(this.clientes.get(3l)));
	}

	// Métodos auxiliares

	protected List<ClienteDTO> getClientes(Long... ids) {
		List<ClienteDTO> clientes = Lists.newArrayList();
		for (Long id : ids) {
			clientes.add(this.clienteDtos.get(id));
		}
		return clientes;
	}
	protected List<EmprestimoDTO> getEmprestimos(Long... ids) {
		List<EmprestimoDTO> emprestimos = Lists.newArrayList();
		for (Long id : ids) {
			emprestimos.add(this.emprestimoDtos.get(id));
		}
		return emprestimos;
	}
	protected List<FuncionarioDTO> getFuncionarios(Long... ids) {
		List<FuncionarioDTO> funcionarios = Lists.newArrayList();
		for (Long id : ids) {
			funcionarios.add(this.funcionarioDtos.get(id));
		}
		return funcionarios;
	}
	protected List<LivroDTO> getLivros(Long... ids) {
		List<LivroDTO> livros = Lists.newArrayList();
		for (Long id : ids) {
			livros.add(this.livroDtos.get(id));
		}
		return livros;
	}


}

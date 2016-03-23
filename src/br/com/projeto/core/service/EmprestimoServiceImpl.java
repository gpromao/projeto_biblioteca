package br.com.projeto.core.service;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.api.dao.EmprestimoDAO;
import br.com.projeto.api.dto.EmprestimoDTO;
import br.com.projeto.api.dto.FuncionarioDTO;
import br.com.projeto.api.dto.LivroDTO;
import br.com.projeto.api.dto.ClienteDTO;
import br.com.projeto.api.entity.Cliente;
import br.com.projeto.api.entity.Funcionario;
import br.com.projeto.api.entity.Emprestimo;
import br.com.projeto.api.entity.Livro;
import br.com.projeto.api.service.EmprestimoService;
import br.com.projeto.core.converter.ClienteDTOConverter;
import br.com.projeto.core.converter.EmprestimoDTOConverter;
import br.com.projeto.core.converter.FuncionarioDTOConverter;
import br.com.projeto.core.converter.LivroDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class EmprestimoServiceImpl implements EmprestimoService {

	// DAO
	private EmprestimoDAO emprestimoDAO;

	// Converter
	private ClienteDTOConverter clienteConverter;
	private EmprestimoDTOConverter emprestimoConverter;
	private FuncionarioDTOConverter funcionarioConverter;
	private LivroDTOConverter livroConverter;

	public EmprestimoServiceImpl() {
		// Encontrar instâncias das DAOs e dos Conversores através do ImplFinder
		this.emprestimoDAO = ImplFinder.getImpl(EmprestimoDAO.class);
		// Aqui é usado o método 'getFinalImpl', este não devolve uma
		// implementação da interface, mas sim uam instância da classe passada
		this.clienteConverter = ImplFinder.getFinalImpl(ClienteDTOConverter.class);
		this.emprestimoConverter = ImplFinder.getFinalImpl(EmprestimoDTOConverter.class);
		this.funcionarioConverter = ImplFinder.getFinalImpl(FuncionarioDTOConverter.class);
		this.livroConverter = ImplFinder.getFinalImpl(LivroDTOConverter.class);
	}

	@Override
	public EmprestimoDTO salvar(EmprestimoDTO emprestimoDTO) {
		Emprestimo emprestimoEntidade = this.emprestimoConverter.toEntity(emprestimoDTO);
		Long id = this.emprestimoDAO.save(emprestimoEntidade);
		emprestimoDTO.setId_emp(id);
		return emprestimoDTO;
	}

	@Override
	public void atualizar(EmprestimoDTO emprestimoDTO) {
		Emprestimo emprestimoEntidade = this.emprestimoConverter.toEntity(emprestimoDTO);
		this.emprestimoDAO.update(emprestimoEntidade);
	}


	@Override
	public void deletar(Long emprestimoId) {
		this.emprestimoDAO.delete(emprestimoId);
	}

	@Override
	public List<EmprestimoDTO> listar() {
		List<Emprestimo> emprestimos = this.emprestimoDAO.findAll();
		return this.emprestimoConverter.toDTO(emprestimos);
	}

	@Override
	public EmprestimoDTO buscarPorId(Long emprestimoId) {
		Emprestimo emprestimo = this.emprestimoDAO.findById(emprestimoId);
		return this.emprestimoConverter.toDTO(emprestimo);
	}

}

package br.com.projeto.core.service;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.api.dao.FuncionarioDAO;
import br.com.projeto.api.dto.EmprestimoDTO;
import br.com.projeto.api.dto.FuncionarioDTO;
import br.com.projeto.api.dto.LivroDTO;
import br.com.projeto.api.dto.ClienteDTO;
import br.com.projeto.api.entity.Cliente;
import br.com.projeto.api.entity.Funcionario;
import br.com.projeto.api.entity.Emprestimo;
import br.com.projeto.api.entity.Livro;
import br.com.projeto.api.service.FuncionarioService;
import br.com.projeto.core.converter.ClienteDTOConverter;
import br.com.projeto.core.converter.EmprestimoDTOConverter;
import br.com.projeto.core.converter.FuncionarioDTOConverter;
import br.com.projeto.core.converter.LivroDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class FuncionarioServiceImpl implements FuncionarioService {

	// DAO
	private FuncionarioDAO funcionarioDAO;

	// Converter
	private ClienteDTOConverter clienteConverter;
	private EmprestimoDTOConverter emprestimoConverter;
	private FuncionarioDTOConverter funcionarioConverter;
	private LivroDTOConverter livroConverter;

	public FuncionarioServiceImpl() {
		// Encontrar instâncias das DAOs e dos Conversores através do ImplFinder
		this.funcionarioDAO = ImplFinder.getImpl(FuncionarioDAO.class);
		// Aqui é usado o método 'getFinalImpl', este não devolve uma
		// implementação da interface, mas sim uam instância da classe passada
		this.clienteConverter = ImplFinder.getFinalImpl(ClienteDTOConverter.class);
		this.emprestimoConverter = ImplFinder.getFinalImpl(EmprestimoDTOConverter.class);
		this.funcionarioConverter = ImplFinder.getFinalImpl(FuncionarioDTOConverter.class);
		this.livroConverter = ImplFinder.getFinalImpl(LivroDTOConverter.class);
	}

	@Override
	public FuncionarioDTO salvar(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionarioEntidade = this.funcionarioConverter.toEntity(funcionarioDTO);
		Long id = this.funcionarioDAO.save(funcionarioEntidade);
		funcionarioDTO.setId_funcionario(id);
		return funcionarioDTO;
	}

	@Override
	public void atualizar(FuncionarioDTO funcionarioDTO) {
		Funcionario funcionarioEntidade = this.funcionarioConverter.toEntity(funcionarioDTO);
		this.funcionarioDAO.update(funcionarioEntidade);
	}


	@Override
	public void deletar(Long funcionarioId) {
		this.funcionarioDAO.delete(funcionarioId);
	}

	@Override
	public List<FuncionarioDTO> listar() {
		List<Funcionario> funcionarios = this.funcionarioDAO.findAll();
		return this.funcionarioConverter.toDTO(funcionarios);
	}

	@Override
	public FuncionarioDTO buscarPorId(Long funcionarioId) {
		Funcionario funcionario = this.funcionarioDAO.findById(funcionarioId);
		return this.funcionarioConverter.toDTO(funcionario);
	}

}

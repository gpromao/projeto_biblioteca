package br.com.projeto.core.service;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.api.dao.LivroDAO;
import br.com.projeto.api.dto.EmprestimoDTO;
import br.com.projeto.api.dto.FuncionarioDTO;
import br.com.projeto.api.dto.LivroDTO;
import br.com.projeto.api.dto.ClienteDTO;
import br.com.projeto.api.entity.Cliente;
import br.com.projeto.api.entity.Funcionario;
import br.com.projeto.api.entity.Emprestimo;
import br.com.projeto.api.entity.Livro;
import br.com.projeto.api.service.LivroService;
import br.com.projeto.core.converter.ClienteDTOConverter;
import br.com.projeto.core.converter.EmprestimoDTOConverter;
import br.com.projeto.core.converter.FuncionarioDTOConverter;
import br.com.projeto.core.converter.LivroDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class LivroServiceImpl implements LivroService {

	// DAO
	private LivroDAO livroDAO;

	// Converter
	private ClienteDTOConverter clienteConverter;
	private EmprestimoDTOConverter emprestimoConverter;
	private FuncionarioDTOConverter funcionarioConverter;
	private LivroDTOConverter livroConverter;

	public LivroServiceImpl() {
		// Encontrar instâncias das DAOs e dos Conversores através do ImplFinder
		this.livroDAO = ImplFinder.getImpl(LivroDAO.class);
		// Aqui é usado o método 'getFinalImpl', este não devolve uma
		// implementação da interface, mas sim uam instância da classe passada
		this.clienteConverter = ImplFinder.getFinalImpl(ClienteDTOConverter.class);
		this.emprestimoConverter = ImplFinder.getFinalImpl(EmprestimoDTOConverter.class);
		this.funcionarioConverter = ImplFinder.getFinalImpl(FuncionarioDTOConverter.class);
		this.livroConverter = ImplFinder.getFinalImpl(LivroDTOConverter.class);
	}

	@Override
	public LivroDTO salvar(LivroDTO livroDTO) {
		Livro livroEntidade = this.livroConverter.toEntity(livroDTO);
		Long id = this.livroDAO.save(livroEntidade);
		livroDTO.setId_livro(id);
		return livroDTO;
	}

	@Override
	public void atualizar(LivroDTO livroDTO) {
		Livro livroEntidade = this.livroConverter.toEntity(livroDTO);
		this.livroDAO.update(livroEntidade);
	}


	@Override
	public void deletar(Long livroId) {
		this.livroDAO.delete(livroId);
	}

	@Override
	public List<LivroDTO> listar() {
		List<Livro> livros = this.livroDAO.findAll();
		return this.livroConverter.toDTO(livros);
	}

	@Override
	public LivroDTO buscarPorId(Long livroId) {
		Livro livro = this.livroDAO.findById(livroId);
		return this.livroConverter.toDTO(livro);
	}

}

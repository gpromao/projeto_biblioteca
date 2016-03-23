package br.com.projeto.core.service;

import java.util.ArrayList;
import java.util.List;

import br.com.projeto.api.dao.ClienteDAO;
import br.com.projeto.api.dto.EmprestimoDTO;
import br.com.projeto.api.dto.FuncionarioDTO;
import br.com.projeto.api.dto.LivroDTO;
import br.com.projeto.api.dto.ClienteDTO;
import br.com.projeto.api.entity.Cliente;
import br.com.projeto.api.entity.Funcionario;
import br.com.projeto.api.entity.Emprestimo;
import br.com.projeto.api.entity.Livro;
import br.com.projeto.api.service.ClienteService;
import br.com.projeto.core.converter.ClienteDTOConverter;
import br.com.projeto.core.converter.EmprestimoDTOConverter;
import br.com.projeto.core.converter.FuncionarioDTOConverter;
import br.com.projeto.core.converter.LivroDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClienteServiceImpl implements ClienteService {

	// DAO
	private ClienteDAO clienteDAO;

	// Converter
	private ClienteDTOConverter clienteConverter;
	private EmprestimoDTOConverter emprestimoConverter;
	private FuncionarioDTOConverter funcionarioConverter;
	private LivroDTOConverter livroConverter;

	public ClienteServiceImpl() {
		// Encontrar instâncias das DAOs e dos Conversores através do ImplFinder
		this.clienteDAO = ImplFinder.getImpl(ClienteDAO.class);
		// Aqui é usado o método 'getFinalImpl', este não devolve uma
		// implementação da interface, mas sim uam instância da classe passada
		this.clienteConverter = ImplFinder.getFinalImpl(ClienteDTOConverter.class);
		this.emprestimoConverter = ImplFinder.getFinalImpl(EmprestimoDTOConverter.class);
		this.funcionarioConverter = ImplFinder.getFinalImpl(FuncionarioDTOConverter.class);
		this.livroConverter = ImplFinder.getFinalImpl(LivroDTOConverter.class);
	}

	@Override
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente clienteEntidade = this.clienteConverter.toEntity(clienteDTO);
		Long id = this.clienteDAO.save(clienteEntidade);
		clienteDTO.setId_cliente(id);
		return clienteDTO;
	}

	@Override
	public void atualizar(ClienteDTO clienteDTO) {
		Cliente clienteEntidade = this.clienteConverter.toEntity(clienteDTO);
		this.clienteDAO.update(clienteEntidade);
	}


	@Override
	public void deletar(Long clienteId) {
		this.clienteDAO.delete(clienteId);
	}

	@Override
	public List<ClienteDTO> listar() {
		List<Cliente> clientes = this.clienteDAO.findAll();
		return this.clienteConverter.toDTO(clientes);
	}

	@Override
	public ClienteDTO buscarPorId(Long clienteId) {
		Cliente cliente = this.clienteDAO.findById(clienteId);
		return this.clienteConverter.toDTO(cliente);
	}

}

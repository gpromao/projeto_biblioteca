package br.com.projeto.api.service;

import java.util.List;

import br.com.projeto.api.dto.FuncionarioDTO;

public interface FuncionarioService {

	FuncionarioDTO salvar(FuncionarioDTO funcionario);

	void atualizar(FuncionarioDTO funcionario);

	void deletar(Long funcionarioId);

	List<FuncionarioDTO> listar();

	FuncionarioDTO buscarPorId(Long funcionarioId);

}
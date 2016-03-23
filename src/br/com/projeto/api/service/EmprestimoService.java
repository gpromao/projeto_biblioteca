package br.com.projeto.api.service;

import java.util.List;

import br.com.projeto.api.dto.EmprestimoDTO;

public interface EmprestimoService {

	EmprestimoDTO salvar(EmprestimoDTO emprestimo);

	void atualizar(EmprestimoDTO emprestimo);

	void deletar(Long emprestimoId);

	List<EmprestimoDTO> listar();

	EmprestimoDTO buscarPorId(Long emprestimoId);

}
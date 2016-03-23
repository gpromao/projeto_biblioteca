package br.com.projeto.api.service;

import java.util.List;

import br.com.projeto.api.dto.LivroDTO;

public interface LivroService {

	LivroDTO salvar(LivroDTO livro);

	void atualizar(LivroDTO livro);

	void deletar(Long livroId);

	List<LivroDTO> listar();

	LivroDTO buscarPorId(Long livroId);

}
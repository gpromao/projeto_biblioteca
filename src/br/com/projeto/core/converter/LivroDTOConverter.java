package br.com.projeto.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.projeto.api.dto.LivroDTO;
import br.com.projeto.api.entity.Livro;
import br.com.spektro.minispring.dto.DTOConverter;

public class LivroDTOConverter implements DTOConverter<Livro, LivroDTO> {

	@Override
	public LivroDTO toDTO(Livro entidade) {
		LivroDTO dto = new LivroDTO();
		dto.setId_livro(entidade.getId_livro());
		dto.setTitulo(entidade.getTitulo());
		dto.setAutor(entidade.getAutor());
		dto.setGenero(entidade.getGenero());
		dto.setEditora(entidade.getEditora());
		dto.setEmp_id(entidade.getEmp_id());
		return dto;
	}

	@Override
	public Livro toEntity(LivroDTO dto) {
		Livro entidade = new Livro();
		entidade.setId_livro(dto.getId_livro());
		entidade.setTitulo(dto.getTitulo());
		entidade.setAutor(dto.getAutor());
		entidade.setGenero(dto.getGenero());
		entidade.setEditora(dto.getEditora());
		entidade.setEmp_id(dto.getEmp_id());
		return entidade;
	}

	@Override
	public List<LivroDTO> toDTO(List<Livro> entidades) {
		List<LivroDTO> dtos = Lists.newArrayList();
		for (Livro entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public List<Livro> toEntity(List<LivroDTO> dtos) {
		List<Livro> entidades = Lists.newArrayList();
		for (LivroDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}

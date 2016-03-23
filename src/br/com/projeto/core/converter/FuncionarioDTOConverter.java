package br.com.projeto.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.projeto.api.dto.FuncionarioDTO;
import br.com.projeto.api.entity.Funcionario;
import br.com.spektro.minispring.dto.DTOConverter;

public class FuncionarioDTOConverter implements DTOConverter<Funcionario, FuncionarioDTO> {

	@Override
	public FuncionarioDTO toDTO(Funcionario entidade) {
		FuncionarioDTO dto = new FuncionarioDTO();
		dto.setId_funcionario(entidade.getId_funcionario());
		dto.setNome_func(entidade.getNome_func());
		return dto;
	}

	@Override
	public Funcionario toEntity(FuncionarioDTO dto) {
		Funcionario entidade = new Funcionario();
		entidade.setId_funcionario(dto.getId_funcionario());
		entidade.setNome_func(dto.getNome_func());
		return entidade;
	}

	@Override
	public List<FuncionarioDTO> toDTO(List<Funcionario> entidades) {
		List<FuncionarioDTO> dtos = Lists.newArrayList();
		for (Funcionario entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public List<Funcionario> toEntity(List<FuncionarioDTO> dtos) {
		List<Funcionario> entidades = Lists.newArrayList();
		for (FuncionarioDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}

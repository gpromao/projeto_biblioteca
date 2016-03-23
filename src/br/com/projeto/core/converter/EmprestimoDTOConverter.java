package br.com.projeto.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.projeto.api.dto.EmprestimoDTO;
import br.com.projeto.api.entity.Emprestimo;
import br.com.spektro.minispring.dto.DTOConverter;

public class EmprestimoDTOConverter implements DTOConverter<Emprestimo, EmprestimoDTO> {

	@Override
	public EmprestimoDTO toDTO(Emprestimo entidade) {
		EmprestimoDTO dto = new EmprestimoDTO();
		dto.setId_emp(entidade.getId_emp());
		dto.setLivro_emp(entidade.getLivro_emp());
		dto.setCliente_emp(entidade.getCliente_emp());
		dto.setFunc_emp(entidade.getFunc_emp());
		dto.setData_entrada(entidade.getData_entrada());
		dto.setData_devolucao(entidade.getData_devolucao());
		dto.setStatus(entidade.getStatus());
		return dto;
	}

	@Override
	public Emprestimo toEntity(EmprestimoDTO dto) {
		Emprestimo entidade = new Emprestimo();
		entidade.setId_emp(dto.getId_emp());
		entidade.setLivro_emp(dto.getLivro_emp());
		entidade.setCliente_emp(dto.getCliente_emp());
		entidade.setFunc_emp(dto.getFunc_emp());
		entidade.setData_entrada(dto.getData_entrada());
		entidade.setData_devolucao(dto.getData_devolucao());
		entidade.setStatus(dto.getStatus());
		return entidade;
	}

	@Override
	public List<EmprestimoDTO> toDTO(List<Emprestimo> entidades) {
		List<EmprestimoDTO> dtos = Lists.newArrayList();
		for (Emprestimo entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public List<Emprestimo> toEntity(List<EmprestimoDTO> dtos) {
		List<Emprestimo> entidades = Lists.newArrayList();
		for (EmprestimoDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}

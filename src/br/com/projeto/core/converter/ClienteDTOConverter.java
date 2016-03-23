package br.com.projeto.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.projeto.api.dto.ClienteDTO;
import br.com.projeto.api.entity.Cliente;
import br.com.spektro.minispring.dto.DTOConverter;

public class ClienteDTOConverter implements DTOConverter<Cliente, ClienteDTO> {

	@Override
	public ClienteDTO toDTO(Cliente entidade) {
		ClienteDTO dto = new ClienteDTO();
		dto.setId_cliente(entidade.getId_cliente());
		dto.setNome_cliente(entidade.getNome_cliente());
		dto.setEndereco(entidade.getEndereco());
		dto.setNascimento(entidade.getNascimento());
		return dto;
	}

	@Override
	public Cliente toEntity(ClienteDTO dto) {
		Cliente entidade = new Cliente();
		entidade.setId_cliente(dto.getId_cliente());
		entidade.setNome_cliente(dto.getNome_cliente());
		entidade.setEndereco(dto.getEndereco());
		entidade.setNascimento(dto.getNascimento());
		return entidade;
	}

	@Override
	public List<ClienteDTO> toDTO(List<Cliente> entidades) {
		List<ClienteDTO> dtos = Lists.newArrayList();
		for (Cliente entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public List<Cliente> toEntity(List<ClienteDTO> dtos) {
		List<Cliente> entidades = Lists.newArrayList();
		for (ClienteDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}

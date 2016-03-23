package br.com.projeto.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.projeto.api.dao.ClienteDAO;
import br.com.projeto.api.entity.Cliente;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public Long save(Cliente cliente) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Cliente.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					2, "SEQ_PROJETO_CLIENTE");

			String sql = "INSERT INTO " + Cliente.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Cliente.getColunasArray());

			insert.setString(1, cliente.getNome_cliente());
			insert.setString(2, cliente.getEndereco());
			insert.setString(3, cliente.getNascimento());
			insert.execute();

			ResultSet generatedKeys = insert.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getLong(1);
			}

			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(insert);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public void update(Cliente cliente) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Cliente.TABLE + " SET "
					+ Cliente.COL_NOME + " = ?, " + Cliente.COL_END + " = ? "
					+ Cliente.COL_NASC + " = ? "
					+ " WHERE " + Cliente.COL_ID + " = ?");
			update.setString(1, cliente.getNome_cliente());
			update.setString(2, cliente.getEndereco());
			update.setString(3, cliente.getNascimento());
			update.setLong(4, cliente.getId_cliente());
			update.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(update);
		}
	}

	@Override
	public void delete(Long id) {
		Connection conn = null;
		PreparedStatement delete = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "DELETE FROM " + Cliente.TABLE + " WHERE ID = ?;";
			delete = conn.prepareStatement(sql);
			delete.setLong(1, id);
			delete.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(delete);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public Cliente findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Cliente cliente = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Cliente.TABLE + " WHERE " + Cliente.COL_ID
					+ " = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				cliente = this.buildCliente(rs);
			}
			return cliente;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Cliente> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Cliente.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildClientes(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Cliente> buildClientes(ResultSet rs) throws SQLException {
		List<Cliente> clientes = Lists.newArrayList();
		while (rs.next()) {
			clientes.add(this.buildCliente(rs));
		}
		return clientes;
	}

	private Cliente buildCliente(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId_cliente(rs.getLong(Cliente.COL_ID));
		cliente.setNome_cliente(rs.getString(Cliente.COL_NOME));
		cliente.setEndereco(rs.getString(Cliente.COL_END));
		cliente.setNascimento(rs.getString(Cliente.COL_NASC));
		return cliente;
	}

}

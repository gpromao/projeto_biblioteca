package br.com.projeto.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.projeto.api.dao.FuncionarioDAO;
import br.com.projeto.api.entity.Funcionario;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class FuncionarioDAOImpl implements FuncionarioDAO {

	@Override
	public Long save(Funcionario funcionario) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Funcionario.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					2, "SEQ_PROJETO_FUNCIONARIO");

			String sql = "INSERT INTO " + Funcionario.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Funcionario.getColunasArray());

			insert.setString(1, funcionario.getNome_func());
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
	public void update(Funcionario funcionario) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Funcionario.TABLE + " SET "
					+ Funcionario.COL_NOME + " = ?, "
					+ " WHERE " + Funcionario.COL_ID + " = ?");
			update.setString(1, funcionario.getNome_func());
			update.setLong(2, funcionario.getId_funcionario());
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
			String sql = "DELETE FROM " + Funcionario.TABLE + " WHERE ID = ?;";
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
	public Funcionario findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Funcionario cliente = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Funcionario.TABLE + " WHERE " + Funcionario.COL_ID
					+ " = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				cliente = this.buildFuncionario(rs);
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
	public List<Funcionario> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Funcionario.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildFuncionarios(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Funcionario> buildFuncionarios(ResultSet rs) throws SQLException {
		List<Funcionario> funcionarios = Lists.newArrayList();
		while (rs.next()) {
			funcionarios.add(this.buildFuncionario(rs));
		}
		return funcionarios;
	}

	private Funcionario buildFuncionario(ResultSet rs) throws SQLException {
		Funcionario funcionario = new Funcionario();
		funcionario.setId_funcionario(rs.getLong(Funcionario.COL_ID));
		funcionario.setNome_func(rs.getString(Funcionario.COL_NOME));
		return funcionario;
	}

}

package br.com.projeto.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.projeto.api.dao.EmprestimoDAO;
import br.com.projeto.api.entity.Emprestimo;
import br.com.projeto.api.entity.Long;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class EmprestimoDAOImpl implements EmprestimoDAO {

	@Override
	public Long save(Emprestimo emprestimo) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Cliente.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					2, "SEQ_PROJETO_EMPRESTIMO");

			String sql = "INSERT INTO " + Emprestimo.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Emprestimo.getColunasArray());
			
			insert.setLong(1, emprestimo.getLivro_emp());
			insert.setLong(2, emprestimo.getCliente_emp());
			insert.setLong(3, emprestimo.getFunc_emp());
			insert.setString(4, emprestimo.getData_entrada());
			insert.setString(5, emprestimo.getData_devolucao());
			insert.setString(6, emprestimo.getStatus());
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
	public void update(Emprestimo emprestimo) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Emprestimo.TABLE + " SET "
					+ Emprestimo.COL_LIVRO + " = ?, " + Emprestimo.COL_CLIENTE + " = ? "
					+ Emprestimo.COL_FUNCIONARIO + " = ? " + Emprestimo.COL_ENTRADA + " = ?, "
					+ Emprestimo.COL_DEVOLUCAO + " = ?, " + Emprestimo.COL_STATUS + " = ?, "
					+ " WHERE " + Emprestimo.COL_ID + " = ?");
			update.setLong(1, emprestimo.getLivro_emp());
			update.setLong(2, emprestimo.getCliente_emp());
			update.setLong(3, emprestimo.getFunc_emp());
			update.setString(4, emprestimo.getData_entrada());
			update.setString(5, emprestimo.getData_devolucao());
			update.setString(6, emprestimo.getStatus());
			update.setLong(7, emprestimo.getId_emp());
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
			String sql = "DELETE FROM " + Emprestimo.TABLE + " WHERE ID = ?;";
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
	public Emprestimo findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Emprestimo emprestimo = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Emprestimo.TABLE + " WHERE " + Emprestimo.COL_ID
					+ " = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				emprestimo  = this.buildEmprestimo(rs);
			}
			return emprestimo ;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Emprestimo> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Emprestimo.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildEmprestimos(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Emprestimo> buildEmprestimos(ResultSet rs) throws SQLException {
		List<Emprestimo> emprestimos = Lists.newArrayList();
		while (rs.next()) {
			emprestimos.add(this.buildEmprestimo(rs));
		}
		return emprestimos;
	}

	private Emprestimo buildEmprestimo(ResultSet rs) throws SQLException {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setId_emp(rs.getLong(Emprestimo.COL_ID));
		emprestimo.setLivro_emp(rs.getLong(Emprestimo.COL_LIVRO));
		emprestimo.setCliente_emp(rs.getLong(Emprestimo.COL_CLIENTE));
		emprestimo.setFunc_emp(rs.getLong(Emprestimo.COL_FUNCIONARIO));
		emprestimo.setData_entrada(rs.getString(Emprestimo.COL_ENTRADA));
		emprestimo.setData_devolucao(rs.getString(Emprestimo.COL_DEVOLUCAO));
		emprestimo.setStatus(rs.getString(Emprestimo.COL_STATUS));
		return emprestimo;
	}

}

package br.com.projeto.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.projeto.api.dao.LivroDAO;
import br.com.projeto.api.entity.Livro;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class LivroDAOImpl implements LivroDAO {

	@Override
	public Long save(Livro livro) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Livro.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					2, "SEQ_PROJETO_LIVRO");

			String sql = "INSERT INTO " + Livro.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Livro.getColunasArray());

			insert.setString(1, livro.getTitulo());
			insert.setString(2, livro.getAutor());
			insert.setString(3, livro.getGenero());
			insert.setString(4, livro.getEditora());
			insert.setLong(5, livro.getEmp_id());
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
	public void update(Livro livro) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Livro.TABLE + " SET "
					+ Livro.COL_TITULO + " = ?, " + Livro.COL_AUTOR + " = ? "
					+ Livro.COL_GENERO + " = ? " + Livro.COL_EDITORA + " = ? "
					+ Livro.COL_EMPRESTIMO + " = ? "
					+ " WHERE " + Livro.COL_ID + " = ?");
			update.setString(1, livro.getTitulo());
			update.setString(2, livro.getAutor());
			update.setString(3, livro.getGenero());
			update.setString(4, livro.getEditora());
			update.setLong(5, livro.getEmp_id());
			update.setLong(6, livro.getId_livro());
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
			String sql = "DELETE FROM " + Livro.TABLE + " WHERE ID = ?;";
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
	public Livro findById(Long id) {
		Connection conn = null;
		PreparedStatement find = null;
		Livro livro = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Livro.TABLE + " WHERE " + Livro.COL_ID
					+ " = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, id);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				livro = this.buildLivro(rs);
			}
			return livro;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Livro> findAll() {
		Connection conn = null;
		PreparedStatement findAll = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			findAll = conn.prepareStatement("SELECT * FROM " + Livro.TABLE);
			ResultSet rs = findAll.executeQuery();
			return this.buildLivros(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(findAll);
		}
	}

	private List<Livro> buildLivros(ResultSet rs) throws SQLException {
		List<Livro> livros = Lists.newArrayList();
		while (rs.next()) {
			livros.add(this.buildLivro(rs));
		}
		return livros;
	}

	private Livro buildLivro(ResultSet rs) throws SQLException {
		Livro livro = new Livro();
		livro.setId_livro(rs.getLong(Livro.COL_ID));
		livro.setTitulo(rs.getString(Livro.COL_TITULO));
		livro.setAutor(rs.getString(Livro.COL_AUTOR));
		livro.setGenero(rs.getString(Livro.COL_GENERO));
		livro.setEditora(rs.getString(Livro.COL_EDITORA));
		livro.setEmp_id(rs.getLong(Livro.COL_EMPRESTIMO));
		return livro;
	}

}

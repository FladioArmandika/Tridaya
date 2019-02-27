package com.fladioarmandika.tridaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.fladioarmandika.tridaya.model.MataPelajaran;
import com.fladioarmandika.tridaya.service.ProgramService;

public class MataPelajaranDaoImpl implements MataPelajaranDao {
	
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProgramDao programDao;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}

	@Override
	public MataPelajaran getMataPelajaran(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM mata_pelajaran WHERE id_matpel = ? ", 
				new RowMapper<MataPelajaran>() {
					@Override
					public MataPelajaran mapRow(ResultSet rs, int row) throws SQLException {
						MataPelajaran mataPelajaran = new MataPelajaran();
						mataPelajaran.setId(rs.getInt("id_matpel"));
						mataPelajaran.setNamaMataPelajaran(rs.getString("nama_matpel"));
						mataPelajaran.setProgram(programDao.getProgram(rs.getInt("id_program")));
						return mataPelajaran;
					}
			
				}
		,id); 
	}

	@Override
	public List<MataPelajaran> getAllMataPelajaran() {
		return jdbcTemplate.query("SELECT * FROM mata_pelajaran", 
				new RowMapper<MataPelajaran>() {
					@Override
					public MataPelajaran mapRow(ResultSet rs, int row) throws SQLException {
						MataPelajaran mataPelajaran = new MataPelajaran();
						mataPelajaran.setId(rs.getInt("id_matpel"));
						mataPelajaran.setNamaMataPelajaran(rs.getString("nama_matpel"));
						mataPelajaran.setProgram(programDao.getProgram(rs.getInt("id_program")));
						return mataPelajaran;
					}
				}
		);
	}

	@Override
	public void addMataPelajaran(MataPelajaran mataPelajaran) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement stmt = conn.prepareStatement(""
						+ "INSERT INTO mata_pelajaran(id_matpel,nama_matpel,id_program)"
						+ "VALUES("
						+ mataPelajaran.getId() + ","
						+ "'" + mataPelajaran.getNamaMataPelajaran() + "',"
						+ mataPelajaran.getProgram().getId()
						+ ")");
				return stmt;
			}
		});
	}

	@Override
	public void removeMataPelajaran(int id) {
		jdbcTemplate.update("DELETE FROM mata_pelajaran WHERE id_matpel = " + id);
	}

	@Override
	public void updateMataPelajaran(int id, MataPelajaran mataPelajaran) {
		String sql = "UPDATE mata_pelajaran SET"
				+ "id_matpel = " + mataPelajaran.getId() + ","
				+ "nama_matpel = '" + mataPelajaran.getNamaMataPelajaran() + "',"
				+ "id_program = " + mataPelajaran.getProgram().getId()
				+ "WHERE id_matpel = " + id;
	}
	
	

}

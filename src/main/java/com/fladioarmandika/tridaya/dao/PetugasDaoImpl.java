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

import com.fladioarmandika.tridaya.model.Pengajar;
import com.fladioarmandika.tridaya.model.Petugas;

public class PetugasDaoImpl implements PetugasDao {

	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Petugas getPetugas(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM petugas WHERE id_petugas =  ? ", 
				new RowMapper<Petugas>() {
					@Override
					public Petugas mapRow(ResultSet rs, int row) throws SQLException {
						Petugas petugas = new Petugas();
						petugas.setId(rs.getInt("id_petugas"));
						petugas.setNama(rs.getString("nama_petugas"));
						petugas.setJabatan(rs.getString("jabatan"));
						petugas.setTugas(rs.getString("tugas"));
						return petugas;
					}
			
				}
		,id);
	}

	@Override
	public List<Petugas> getAllPetugas() {
		return jdbcTemplate.query("SELECT * FROM petugas", 
				new RowMapper<Petugas>() {
					@Override
					public Petugas mapRow(ResultSet rs, int row) throws SQLException {
						Petugas petugas = new Petugas();
						petugas.setId(rs.getInt("id_petugas"));
						petugas.setNama(rs.getString("nama_petugas"));
						petugas.setJabatan(rs.getString("jabatan"));
						petugas.setTugas(rs.getString("tugas"));
						return petugas;
					}
				
				}
		);
	}

	@Override
	public void addPetugas(Petugas petugas) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement stmt = conn.prepareStatement(""
						+ "INSERT INTO petugas(id_petugas,nama_petugas,jabatan,tugas)"
						+ "VALUES("
						+ ModelAttributeGenerator.generateId() + ","
						+ "'" + petugas.getNama() + "',"
						+ "'" + petugas.getJabatan() + "',"
						+ "'" + petugas.getTugas() + "'"
						+ ");");
				return stmt;
			}
		});
	}

	@Override
	public void removePetugas(int id) {
		jdbcTemplate.update("DELETE FROM petugas WHERE id_petugas = " + id);
	}

	@Override
	public void updatePetugas(int id, Petugas petugas) {
		String sql = "UPDATE petugas SET"
				+ "id_petugas = " + petugas.getId() + ","
				+ "nama_petugas = '" + petugas.getNama() + "',"
				+ "jabatan = '" + petugas.getJabatan() + "',"
				+ "tugas = '" + petugas.getTugas() + "'"
				+ "WHERE id_petugas = " + id;
		jdbcTemplate.update(sql);
	}

	@Override
	public int getJumPetugas() {
		return jdbcTemplate.queryForObject("SELECT COUNT(id_petugas) FROM petugas",
				new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						int jumPetugas = rs.getInt("COUNT(id_petugas)");
						return jumPetugas;
					}
				}
		);
	}

}

















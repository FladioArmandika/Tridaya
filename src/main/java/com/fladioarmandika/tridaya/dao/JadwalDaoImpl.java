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

import com.fladioarmandika.tridaya.model.Jadwal;

public class JadwalDaoImpl implements JadwalDao {

	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Jadwal getJadwal(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM jadwal WHERE id_jadwal = ? ", 
				new RowMapper<Jadwal>() {
					@Override
					public Jadwal mapRow(ResultSet rs, int row) throws SQLException {
						Jadwal jadwal = new Jadwal();
						jadwal.setId(rs.getInt("id_jadwal"));
						jadwal.setHari(rs.getString("hari"));
						jadwal.setJam(rs.getInt("jam"));
						return jadwal;
					}
				}
		,id);
	}

	@Override
	public List<Jadwal> getAllJadwal() {
		return jdbcTemplate.query("SELECT * FROM jadwal", 
				new RowMapper<Jadwal>() {
					@Override
					public Jadwal mapRow(ResultSet rs, int row) throws SQLException {
						Jadwal jadwal = new Jadwal();
						jadwal.setId(rs.getInt("id_jadwal"));
						jadwal.setHari(rs.getString("hari"));
						jadwal.setJam(rs.getInt("jam"));
						return jadwal;
					}
				}
		);
	}

	@Override
	public void addJadwal(Jadwal jadwal) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement stmt = conn.prepareStatement(""
						+ "INSERT INTO jadwal(id_jadwal,hari,jam)"
						+ "VALUES("
						+ jadwal.getId() + ","
						+ "'" + jadwal.getHari() + "',"
						+ jadwal.getJam()
						+ ");");
				return stmt;
			}
		});
	}

	@Override
	public void removeJadwal(int id) {
		jdbcTemplate.update("DELETE FROM jadwal WHERE id_jadwal = " + id);
	}

	@Override
	public void updateJadwal(int id, Jadwal jadwal) {
		String sql = "UPDATE jadwal SET"
				+ "id_jadwal = " + jadwal.getId() + "," 
				+ "hari = '" + jadwal.getHari() + "',"
				+ "jam = " + jadwal.getJam()
				+ "WHERE id_jadwal = " + id + ";";
		jdbcTemplate.update(sql);
	}


}

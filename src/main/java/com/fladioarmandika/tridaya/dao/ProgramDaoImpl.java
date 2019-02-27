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

import com.fladioarmandika.tridaya.model.Program;

public class ProgramDaoImpl implements ProgramDao {
	
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Program getProgram(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM program WHERE id_program = ? " , 
				new RowMapper<Program>() {
					@Override
					public Program mapRow(ResultSet rs, int row) throws SQLException {
						Program program = new Program();
						program.setId(rs.getInt("id_program"));
						program.setNama(rs.getString("nama_program"));
						program.setBayar(rs.getInt("bayar"));
						program.setJumlahSiswa(rs.getInt("jumlah_siswa"));
						program.setTingkat(rs.getInt("tingkat"));
						return program;
					}
				}
		,id);
	}

	@Override
	public List<Program> getAllProgram() {
		return jdbcTemplate.query("SELECT * FROM program", 
				new RowMapper<Program>() {
					@Override
					public Program mapRow(ResultSet rs, int row) throws SQLException {
						Program program = new Program();
						program.setId(rs.getInt("id_program"));
						program.setNama(rs.getString("nama_program"));
						program.setBayar(rs.getInt("bayar"));
						program.setJumlahSiswa(rs.getInt("jumlah_siswa"));
						program.setTingkat(rs.getInt("tingkat"));
						return program;
					}
				}
		);
	}

	@Override
	public void addProgram(Program program) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con.prepareStatement(""
						+ "INSERT INTO program(id_program,nama_program,bayar,jumlah_siswa,tingkat)"
						+ "VALUES("
						+ program.getId() + ",'"
						+ program.getNama() + "',"
						+ program.getBayar() + ","
						+ program.getJumlahSiswa() + ","
						+ program.getTingkat() + ""
						+ ");");
				return stmt;
			}
		});
	}

	@Override
	public void removeProgram(int id) {
		jdbcTemplate.update("DELETE FROM program WHERE id_program = " + id);
	}

	@Override
	public void updateProgram(int id, Program program) {
		String sql = "UPDATE program SET"
				+ "id_program = " + program.getId() + ","
				+ "nama_program = '" + program.getNama() + "',"
				+ "bayar = " + program.getBayar() + ","
				+ "jumlah_siswa = " + program.getJumlahSiswa() + ","
				+ "tingkat = " + program.getTingkat()
				+ "WHERE id_program = " + id;
		jdbcTemplate.update(sql);
	}
	
	

}























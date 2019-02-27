package com.fladioarmandika.tridaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.fladioarmandika.tridaya.model.MataPelajaran;
import com.fladioarmandika.tridaya.model.Pengajar;

public class PengajarDaoImpl implements PengajarDao {

	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Pengajar getPengajar(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM pengajar WHERE id_pengajar = ?",
				new RowMapper<Pengajar>() {
					@Override
					public Pengajar mapRow(ResultSet rs, int row) throws SQLException {
						Pengajar pengajar = new Pengajar();
						pengajar.setId(rs.getInt("id_pengajar"));
						pengajar.setNama(rs.getString("nama_pengajar"));
						pengajar.setNoHp(rs.getString("no_hp"));
						pengajar.setEmail(rs.getString("email"));
						pengajar.setAlamat(rs.getString("alamat"));
						pengajar.setTgl_lahir(rs.getDate("tgl_lahir"));
						pengajar.setJenisKelamin(rs.getString("jenis_kelamin")); 
						return pengajar;
					}
				}
		,id);
	}

	@Override
	public List<Pengajar> getAllPengajar() {
		return jdbcTemplate.query("SELECT * FROM pengajar", 
				new RowMapper<Pengajar>() {
					@Override
					public Pengajar mapRow(ResultSet rs, int row) throws SQLException {
						Pengajar pengajar = new Pengajar();
						pengajar.setId(rs.getInt("id_pengajar"));
						pengajar.setNama(rs.getString("nama_pengajar"));
						pengajar.setNoHp(rs.getString("no_hp"));
						pengajar.setEmail(rs.getString("email"));
						pengajar.setAlamat(rs.getString("alamat"));
						pengajar.setTgl_lahir(rs.getDate("tgl_lahir"));
						pengajar.setJenisKelamin(rs.getString("jenis_kelamin")); 
						return pengajar;
					}
				}
		);
	}

	@Override
	public void addPengajar(Pengajar pengajar) throws ParseException {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
					stmt = conn.prepareStatement(""
							+ "INSERT INTO pengajar(id_pengajar,nama_pengajar,no_hp,email,alamat,jenis_kelamin,tgl_lahir)"
							+ "VALUES("
							+ ModelAttributeGenerator.generateId() + ",'"
							+ pengajar.getNama() + "','"
							+ pengajar.getNoHp() + "','"
							+ pengajar.getEmail() + "','"
							+ pengajar.getAlamat() + "','"
							+ pengajar.getJenisKelamin() + "','"
							+ "1991-02-04" + "'"
							+ ");");
				return stmt;
			}
		});
	}

	@Override
	public void removePengajar(int id) {
		jdbcTemplate.update("DELETE FROM pengajar WHERE id_pengajar = " + id);
	}

	@Override
	public void updatePengajar(int id, Pengajar pengajar) {
		String sql = "UPDATE pengajar SET"
				+ "id_pengajar = " + pengajar.getId() + ","
				+ "nama_pengajar = '" + pengajar.getNama() + "',"
				+ "no_hp = '" + pengajar.getNoHp() + "',"
				+ "email = '" + pengajar.getEmail() + "',"
				+ "alamat = '" + pengajar.getAlamat() + "';";
		jdbcTemplate.update(sql);
 	}

	@Override
	public List<MataPelajaran> getMatpelPengajar() {
		return null;
	}

	@Override
	public int getJumPengajar() {
		return jdbcTemplate.queryForObject("SELECT COUNT(id_pengajar) FROM pengajar",
				new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						int jumPengajar = rs.getInt("COUNT(id_pengajar)");
						return jumPengajar;
					}
				}
		);
	}

	@Override
	public int getJumPengajarAktif() {
		return jdbcTemplate.queryForObject("SELECT DISTINCT COUNT(pengajar.id_pengajar) FROM pengajar JOIN pembelajaran "
				+ "ON pengajar.id_pengajar = pembelajaran.id_pengajar ", 
				new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						int jumPengajar = rs.getInt("COUNT(pengajar.id_pengajar)"); 
						return jumPengajar;
					}
				}
		);
	}

}

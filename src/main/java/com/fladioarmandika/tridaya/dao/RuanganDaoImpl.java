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

import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.model.Ruangan;

public class RuanganDaoImpl implements RuanganDao {

	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PembelajaranDao pembelajaranDao;
	
	@Autowired
	private MataPelajaranDao mataPelajaranDao;
	
	@Autowired
	private PengajarDao pengajarDao;
	
	@Autowired
	private RuanganDao ruanganDao;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Ruangan getRuangan(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM ruangan WHERE id_ruangan = ?", 
				new RowMapper<Ruangan>() {
					@Override
					public Ruangan mapRow(ResultSet rs, int row) throws SQLException {
						Ruangan ruangan = new Ruangan();
						ruangan.setId(rs.getInt("id_ruangan"));
						ruangan.setNama(rs.getString("nama_ruangan"));
						ruangan.setGedung(rs.getString("gedung"));
						ruangan.setLantai(rs.getInt("lantai"));
						ruangan.setKeterangan(rs.getString("keterangan"));
						return ruangan;
					}
				}
		,id);
	}

	@Override
	public List<Ruangan> getAllRuangan() {
		return jdbcTemplate.query("SELECT * FROM ruangan", 
				new RowMapper<Ruangan>() {
					@Override
					public Ruangan mapRow(ResultSet rs, int row) throws SQLException {
						Ruangan ruangan = new Ruangan();
						ruangan.setId(rs.getInt("id_ruangan"));
						ruangan.setNama(rs.getString("nama_ruangan"));
						ruangan.setGedung(rs.getString("gedung"));
						ruangan.setLantai(rs.getInt("lantai"));
						ruangan.setKeterangan(rs.getString("keterangan"));
						return ruangan;
					}
				}
		);
	}

	@Override
	public void addRuangan(Ruangan ruangan) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement stmt = conn.prepareStatement(""
						+ "INSERT INTO ruangan(id_ruangan,nama_ruangan,gedung,lantai,keterangan)"
						+ "VALUES("
						+ ruangan.getId() + ","
						+ "'" + ruangan.getNama() + "',"
						+ "'" + ruangan.getGedung() + "',"
						+ ruangan.getLantai() + "," 
						+ "'" + ruangan.getKeterangan() + "'"
						+ ");");
				return stmt; 
			}
		}); 
	}

	@Override
	public void removeRuangan(int id) {
		jdbcTemplate.update("DELETE FROM ruangan WHERE id_ruangan = " + id);
	}

	@Override
	public void updateRuangan(int id, Ruangan ruangan) {
		String sql = "UPDATE ruangan SET"
				+ "id_ruangan = " + ruangan.getId() + ","
				+ "nama_ruangan = '" + ruangan.getNama() + "',"
				+ "gedung = '" + ruangan.getGedung() + "',"
				+ "lantai = " + ruangan.getLantai() + ","
				+ "keterangan = '" + ruangan.getKeterangan() + "'"
				+ "WHERE id_ruangan = " + id + ";";
		jdbcTemplate.update(sql);
  	}

	@Override
	public List<Pembelajaran> getKelasRuanganSelected(int id) {
		return jdbcTemplate.query("SELECT * FROM pembelajaran WHERE id_ruangan = ?", 
				new RowMapper<Pembelajaran>() {
					@Override
					public Pembelajaran mapRow(ResultSet rs, int row) throws SQLException {
						Pembelajaran pembelajaran = new Pembelajaran();
						pembelajaran.setId(rs.getInt("id_pembelajaran"));
						pembelajaran.setKeterangan(rs.getString("keterangan"));
						pembelajaran.setMataPelajaran(mataPelajaranDao.getMataPelajaran(rs.getInt("id_matpel")));
						pembelajaran.setPengajar(pengajarDao.getPengajar(rs.getInt("id_pengajar")));
						pembelajaran.setRuangan(ruanganDao.getRuangan(rs.getInt("id_ruangan")));
						pembelajaran.setTanggal(rs.getString("tanggal"));
						return pembelajaran; 
					}
				}
		,id);
	}

	@Override
	public List<Ruangan> getListRuanganByTanggal(String tanggal) {
		return jdbcTemplate.query("SELECT * FROM ruangan AS r LEFT JOIN "
				+ "(SELECT * FROM pembelajaran WHERE pembelajaran.tanggal = ? ) AS p " 
				+ "ON r.id_ruangan = p.id_ruangan " 
				+ "WHERE p.id_pembelajaran IS NULL;",
				new RowMapper<Ruangan>() {
					@Override 
					public Ruangan mapRow(ResultSet rs, int row) throws SQLException {
						Ruangan ruangan = new Ruangan(); 
						ruangan.setId(rs.getInt("id_ruangan"));
						ruangan.setNama(rs.getString("nama_ruangan"));
						ruangan.setGedung(rs.getString("gedung"));
						ruangan.setLantai(rs.getInt("lantai"));
						ruangan.setKeterangan(rs.getString("keterangan"));
						return ruangan;
					}
				}
		,tanggal);  
	}

}

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

import com.fladioarmandika.tridaya.model.Pembayaran;
import com.fladioarmandika.tridaya.service.SiswaService;

public class PembayaranDaoImpl implements PembayaranDao {

	
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private SiswaDao siswaDao;
	
	@Autowired
	private PetugasDao petugasDao;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setSiswaDao(SiswaDao siswaDao) {
		this.siswaDao = siswaDao;
	}

	public void setPetugasDao(PetugasDao petugasDao) {
		this.petugasDao = petugasDao;
	}

	@Override
	public Pembayaran getPembayaran(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM pembayaran WHERE id_pembayaran = ?", 
				new RowMapper<Pembayaran>() {
					@Override
					public Pembayaran mapRow(ResultSet rs, int row) throws SQLException {
						Pembayaran pembayaran = new Pembayaran();
						pembayaran.setId(rs.getInt("id_pembayaran"));
						pembayaran.setSiswa(siswaDao.getSiswa(rs.getInt("id_siswa")));
						pembayaran.setTanggal(rs.getString("tgl_bayar"));
						pembayaran.setPetugas(petugasDao.getPetugas(rs.getInt("id_petugas")));
						pembayaran.setJumlahBayar(rs.getInt("jumlah_bayar"));
						return pembayaran;
					}
				}
		,id);
	}

	@Override
	public List<Pembayaran> getAllPembayaran() {
		return jdbcTemplate.query("SELECT * FROM pembayaran", 
				new RowMapper<Pembayaran>() {
					@Override
					public Pembayaran mapRow(ResultSet rs, int row) throws SQLException {
						Pembayaran pembayaran = new Pembayaran();
						pembayaran.setId(rs.getInt("id_pembayaran"));
						pembayaran.setSiswa(siswaDao.getSiswa(rs.getInt("id_siswa")));
						pembayaran.setTanggal(rs.getString("tgl_bayar"));
						pembayaran.setPetugas(petugasDao.getPetugas(rs.getInt("id_petugas")));
						pembayaran.setJumlahBayar(rs.getInt("jumlah_bayar"));
						return pembayaran;
					}
				}
		);
	}

	@Override
	public void addPembayaran(Pembayaran pembayaran) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement stmt = conn.prepareStatement(""
						+ "INSERT INTO pembayaran(id_pembayaran,id_siswa,tgl_bayar,id_petugas,jumlah_bayar)"
						+ "VALUES("
						+ ModelAttributeGenerator.generateId() + ","
						+ pembayaran.getIdSiswa() + ","
						+ "NOW()" + ","
						+ pembayaran.getIdPetugas() + ","
						+ pembayaran.getJumlahBayar()
						+ ");");
				return stmt; 
			}
		});
	}

	@Override
	public void removePembayaran(int id) {
		jdbcTemplate.update("DELETE FROM pembayaran WHERE id_pembayaran = " + id);
	}

	@Override
	public void updatePembayaran(int id, Pembayaran pembayaran) {
		jdbcTemplate.update("UPDATE pembayaran SET"
				+ "id_pembayaran = " + pembayaran.getId() + ","
				+ "id_siswa = " + pembayaran.getIdSiswa() + ","
				+ "tgl_bayar = '" + pembayaran.getTanggal() + "',"
				+ "jumlah_bayar = " + pembayaran.getJumlahBayar()
				+ "WHERE id_pembayaran = " + id + ";");
	}

}

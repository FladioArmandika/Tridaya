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

import com.fladioarmandika.tridaya.model.AbsenRecord;
import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.model.Siswa;

public class PembelajaranDaoImpl implements PembelajaranDao {

	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private JadwalDao jadwalDao;
	
	@Autowired
	private PengajarDao pengajarDao;
	
	@Autowired
	private ProgramDao programDao;
	
	@Autowired
	private MataPelajaranDao mataPelajaranDao;
	
	@Autowired
	private RuanganDao ruanganDao;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setJadwalDao(JadwalDao jadwalDao) {
		this.jadwalDao = jadwalDao;
	}

	public void setPengajarDao(PengajarDao pengajarDao) {
		this.pengajarDao = pengajarDao;
	}

	public void setMataPelajaranDao(MataPelajaranDao mataPelajaranDao) {
		this.mataPelajaranDao = mataPelajaranDao;
	}

	public void setRuanganDao(RuanganDao ruanganDao) {
		this.ruanganDao = ruanganDao;
	}


	@Override
	public Pembelajaran getPembelajaran(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM pembelajaran WHERE id_pembelajaran = ?", 
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
	public List<Pembelajaran> getAllPembelajaran() {
		return jdbcTemplate.query("SELECT * FROM pembelajaran ORDER BY tanggal ASC",    
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
		);
	}

	@Override
	public void addPembelajaran(Pembelajaran pembelajaran) {
		pembelajaran.setKeterangan("");
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement stmt = conn.prepareStatement(""
						+ "INSERT INTO pembelajaran(id_pembelajaran,id_pengajar,id_matpel,id_ruangan,keterangan,tanggal)"
						+ "VALUES("
						+ ModelAttributeGenerator.generateId() + ","
						+ pembelajaran.getIdPengajar() + ","
						+ pembelajaran.getIdMatpel()+ "," 
						+ pembelajaran.getIdRuangan() + ","
						+ "'" + pembelajaran.getKeterangan() + "',"
						+ "'" + pembelajaran.getTanggal() + "'"  
						+ ")");
				return stmt;
			}
		});
	}

	@Override
	public void removePembelajaran(int id) {
		jdbcTemplate.update("DELETE FROM pembelajaran WHERE id_pembelajaran = " + id);
	}

	@Override
	public void updatePembelajaran(int id, Pembelajaran pembelajaran) {
		String sql = "UPDATE pembelajaran SET"
				+ "id_pembelajaran = " + pembelajaran.getId() + ","
				+ "id_pengajar = " + pembelajaran.getPengajar().getId() + ","
				+ "id_matpel = " + pembelajaran.getMataPelajaran().getId() + ","
				+ "id_ruangan = " + pembelajaran.getRuangan().getId() + ","
				+ "tanggal = '" + pembelajaran.getTanggal() + "',"
				+ "keterangan = '" + pembelajaran.getKeterangan() + "'"
				+ "WHERE id_pembelajaran = " + id + ";";
		jdbcTemplate.update(sql);
	}

	@Override
	public List<Siswa> getAbsen(int idPembelajaran) {
		return jdbcTemplate.query("SELECT * FROM absen_record JOIN siswa ON absen_record.id_siswa = siswa.id_siswa "
				+ "WHERE absen_record.id_pembelajaran = ?", 
				new  RowMapper<Siswa>() {
					@Override
					public Siswa mapRow(ResultSet rs, int row) throws SQLException {
						Siswa siswa = new Siswa();
						siswa.setId(rs.getInt("id_siswa"));
						siswa.setNama(rs.getString("nama_siswa"));
						siswa.setJenisKelamin(rs.getString("jenis_kelamin"));
						siswa.setProgram(programDao.getProgram(rs.getInt("id_program")));
						siswa.setAsalSekolah(rs.getString("asal_sekolah"));
						siswa.setNoHp(rs.getString("no_hp"));
						siswa.setEmail(rs.getString("email"));
						siswa.setAlamat(rs.getString("alamat"));
						siswa.setNamaOrtu(rs.getString("namaOrtu"));
						siswa.setTgl_masuk(rs.getString("tgl_masuk"));  
						siswa.setTgl_lahir(rs.getString("tgl_lahir"));
						return siswa;
					}
				}
		,idPembelajaran);
	}

	@Override
	public void addAbsenSiswa(AbsenRecord absenRecord) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement stmt = conn.prepareStatement(""
						+ "INSERT INTO absen_record(id_absen,id_pembelajaran,id_siswa)"
						+ "VALUES("
						+ ModelAttributeGenerator.generateId() +","
						+ absenRecord.getIdPembelajaran() +","
						+ absenRecord.getIdSiswa() + ""
						+ ");");
				return stmt;
			}
		});
	}

	@Override
	public void removeAbsenSiswa(int idKelas, int idSiswa) {
		jdbcTemplate.update("DELETE FROM absen_record WHERE id_pembelajaran = ? AND id_siswa = ?"
				,idKelas,idSiswa);  
	}
	

}



















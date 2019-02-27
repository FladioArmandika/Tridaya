package com.fladioarmandika.tridaya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import com.fladioarmandika.tridaya.model.Pembayaran;
import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.model.Siswa;
import com.fladioarmandika.tridaya.service.ProgramService;

public class SiswaDaoImpl implements SiswaDao {
	
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ProgramDao programDao;
	
	@Autowired
	private SiswaDao siswaDao;
	
	@Autowired
	private PetugasDao petugasDao;
	
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}
	
	public void setSiswaDao(SiswaDao siswaDao) {
		this.siswaDao = siswaDao;
	}

	public void setPetugasDao(PetugasDao petugasDao) {
		this.petugasDao = petugasDao;
	}

	@Override
	public Siswa getSiswa(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM siswa WHERE id_siswa = ? ", 
				new RowMapper<Siswa>() {
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
		,id);
	}

	@Override
	public List<Siswa> getAllSiswa() {
		return jdbcTemplate.query("SELECT * FROM siswa", 
				new RowMapper<Siswa>() {
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
		);
	}

	@Override
	public void addSiswa(Siswa siswa) throws ParseException  {
		
		Random rand = new Random();
		int idsisGenerate = rand.nextInt(99999999) + 20192939; 
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement stmt = con.prepareStatement(""
						+ "INSERT INTO siswa(id_siswa,nama_siswa,jenis_kelamin,id_program,asal_sekolah,no_hp,email,alamat,tgl_masuk,namaOrtu,tgl_lahir)"
						+ "VALUES("
							+ idsisGenerate + ","  
							+ "'" + siswa.getNama() + "',"
							+ "'" + siswa.getJenisKelamin() + "',"
							+ siswa.getIdProgram() + ","
							+ "'" + siswa.getAsalSekolah() + "',"
							+ "'" + siswa.getNoHp() + "',"
							+ "'" + siswa.getEmail() + "',"
							+ "'" + siswa.getAlamat() + "',"
							+ "NOW()," 
							+ "'" + siswa.getNamaOrtu() + "',"
							+ "'" + siswa.getTgl_lahir() + "'"
						+ ");");
				return stmt;
			}
			
		});
		
		
	}

	@Override
	public void removeSiswa(int id) {
		jdbcTemplate.update("DELETE FROM siswa WHERE id_siswa = " + id);
	}

	@Override
	public void updateSiswa(int id, Siswa siswa) {
		String sql = "UPDATE siswa SET"
				+ "id_siswa = " + siswa.getId() + ","
				+ "nama_siswa = '" + siswa.getNama() + "',"
				+ "jenis_kelamin = '" + siswa.getJenisKelamin() + "',"
				+ "id_program = " + siswa.getIdProgram() + ","
				+ "asal_sekolah = '" + siswa.getAsalSekolah() + "',"
				+ "no_hp = '" + siswa.getNoHp() + "',"
				+ "email = '" + siswa.getEmail() + "',"
				+ "alamat = '" + siswa.getAlamat() + "',"
				+ "tgl_masuk = '" + getSiswa(id).getTgl_masuk() + "',"
				+ "namaOrtu = '" + siswa.getNamaOrtu() + "',"
				+ "tgl_lahir = '" + siswa.getTgl_lahir() + "'"
				+ "WHERE id_siswa = " + id;
		jdbcTemplate.update(sql);
	}

	@Override
	public List<Pembayaran> getPembayaran(int id) {
		return jdbcTemplate.query("SELECT * FROM pembayaran WHERE id_siswa = ?",
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
	public int getJumSiswa() {
		return jdbcTemplate.queryForObject("SELECT COUNT(id_siswa) FROM siswa", 
				new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						int jumSiswa = rs.getInt("COUNT(id_siswa)");
						return jumSiswa; 
					}
				}
		);
	} 

	@Override
	public int getJumSiswaSD() {
		return jdbcTemplate.queryForObject("SELECT COUNT(id_siswa) FROM siswa JOIN program "
				+ "ON siswa.id_program = program.id_program WHERE nama_program LIKE '%SD%'", 
				new RowMapper<Integer>() { 
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						int jumSiswa = rs.getInt("COUNT(id_siswa)");
						return jumSiswa; 
					}
				}
		);
	}

	@Override
	public int getJumSiswaSMP() {
		return jdbcTemplate.queryForObject("SELECT COUNT(id_siswa) FROM siswa JOIN program "
				+ "ON siswa.id_program = program.id_program WHERE nama_program LIKE '%SMP%'", 
				new RowMapper<Integer>() { 
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
						int jumSiswa = rs.getInt("COUNT(id_siswa)");
						return jumSiswa; 
					}
				}
		);
	}

	@Override
	public int getJumSiswaSMA() {
		return jdbcTemplate.queryForObject("SELECT COUNT(id_siswa) FROM siswa JOIN program "
				+ "ON siswa.id_program = program.id_program WHERE nama_program LIKE '%SMA%'", 
				new RowMapper<Integer>() { 
					@Override
					public Integer mapRow(ResultSet rs, int rowNum) throws SQLException { 
						int jumSiswa = rs.getInt("COUNT(id_siswa)");
						return jumSiswa; 
					}
				}
		);
	}

	@Override
	public List<Siswa> getListSiswaAvailable(int idKelas) {
		return jdbcTemplate.query("SELECT * FROM siswa AS s LEFT JOIN "
				+ "(SELECT * FROM absen_record WHERE id_pembelajaran = ? ) AS a " 
				+ "ON s.id_siswa = a.id_siswa " 
				+ "WHERE a.id_pembelajaran IS NULL;", 
				new RowMapper<Siswa>() {
					@Override
					public Siswa mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		,idKelas); 
	}

}











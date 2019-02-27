package com.fladioarmandika.tridaya.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Siswa {
	
	private int id;
	private String nama;
	private String jenisKelamin;
	private String tgl_lahir;
	private Program program;
	private String asalSekolah;
	private String noHp;
	private String email;
	private String alamat;
	private String namaOrtu;
	private String tgl_masuk;
	
	private String idProgram;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	public String getAsalSekolah() {
		return asalSekolah;
	}
	public void setAsalSekolah(String asalSekolah) {
		this.asalSekolah = asalSekolah;
	}
	public String getNoHp() {
		return noHp;
	}
	public void setNoHp(String noHp) {
		this.noHp = noHp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAlamat() {
		return alamat;
	}
	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}
	public String getNamaOrtu() {
		return namaOrtu;
	}
	public void setNamaOrtu(String namaOrtu) {
		this.namaOrtu = namaOrtu;
	}
	public String getIdProgram() {
		return idProgram;
	}
	public void setIdProgram(String idProgram) {
		this.idProgram = idProgram;
	}
	public String getTgl_lahir() {
		return tgl_lahir;
	}
	public void setTgl_lahir(String tgl_lahir) {
		this.tgl_lahir = tgl_lahir;
	}
	public String getTgl_masuk() {
		return tgl_masuk;
	}
	public void setTgl_masuk(String tgl_masuk) {
		this.tgl_masuk = tgl_masuk;
	}
	
	
	
	
	
	
	
}

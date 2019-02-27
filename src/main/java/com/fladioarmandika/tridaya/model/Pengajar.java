package com.fladioarmandika.tridaya.model;

import java.util.Date;

public class Pengajar {
	
	private int id;
	private String nama;
	private String noHp;
	private String email;
	private String alamat;
	private String jenisKelamin;
	private Date tgl_lahir;
	
	
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
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public Date getTgl_lahir() {
		return tgl_lahir;
	}
	public void setTgl_lahir(Date tgl_lahir) {
		this.tgl_lahir = tgl_lahir;
	}
	
	
	
	
	
}

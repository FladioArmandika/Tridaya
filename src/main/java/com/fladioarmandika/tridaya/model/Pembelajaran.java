package com.fladioarmandika.tridaya.model;

import java.util.Date;

public class Pembelajaran {

	private int id;
	private Pengajar pengajar;
	private MataPelajaran mataPelajaran;
	private String tanggal;
	private Ruangan ruangan;
	private String keterangan;
	
	private String idPengajar;
	private String idMatpel;
	private String idRuangan;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pengajar getPengajar() {
		return pengajar;
	}
	public void setPengajar(Pengajar pengajar) {
		this.pengajar = pengajar;
	}  
	public MataPelajaran getMataPelajaran() {
		return mataPelajaran;
	}
	public void setMataPelajaran(MataPelajaran mataPelajaran) {
		this.mataPelajaran = mataPelajaran;
	}
	public Ruangan getRuangan() {
		return ruangan;
	}
	public void setRuangan(Ruangan ruangan) {
		this.ruangan = ruangan;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public String getIdPengajar() {
		return idPengajar;
	}
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	public void setIdPengajar(String idPengajar) {
		this.idPengajar = idPengajar;
	}
	public String getIdMatpel() {
		return idMatpel;
	}
	public void setIdMatpel(String idMatpel) {
		this.idMatpel = idMatpel;
	}
	public String getIdRuangan() {
		return idRuangan;
	}
	public void setIdRuangan(String idRuangan) {
		this.idRuangan = idRuangan;
	}
	
}

package com.fladioarmandika.tridaya.model;

public class Pembayaran {

	private int id;
	private Siswa siswa;
	private String tanggal;
	private Petugas petugas;
	private int jumlahBayar;
	
	private String idSiswa;
	private String idPetugas;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Siswa getSiswa() {
		return siswa;
	}
	public void setSiswa(Siswa siswa) {
		this.siswa = siswa;
	}
	public String getTanggal() {
		return tanggal;
	}
	public void setTanggal(String tanggal) {
		this.tanggal = tanggal;
	}
	public Petugas getPetugas() {
		return petugas;
	}
	public void setPetugas(Petugas petugas) {
		this.petugas = petugas;
	}
	public int getJumlahBayar() {
		return jumlahBayar;
	}
	public void setJumlahBayar(int jumlahBayar) {
		this.jumlahBayar = jumlahBayar;
	}
	public String getIdSiswa() {
		return idSiswa;
	}
	public void setIdSiswa(String idSiswa) {
		this.idSiswa = idSiswa;
	}
	public String getIdPetugas() {
		return idPetugas;
	}
	public void setIdPetugas(String idPetugas) {
		this.idPetugas = idPetugas;
	}
	
}

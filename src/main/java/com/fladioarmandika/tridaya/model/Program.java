package com.fladioarmandika.tridaya.model;

public class Program {

	private int id;
	private String nama;
	private int bayar;
	private int jumlahSiswa;
	private int tingkat;
	
	public Program() {
		
	}
	
	public Program(int id, String nama, int bayar, int jumlahSiswa, int tingkat) {
		this.id = id;
		this.nama = nama;
		this.bayar = bayar;
		this.jumlahSiswa = jumlahSiswa;
		this.tingkat = tingkat;
	}
	
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
	
	public int getBayar() {
		return bayar;
	}
	
	public void setBayar(int bayar) {
		this.bayar = bayar;
	}
	
	public int getJumlahSiswa() {
		return jumlahSiswa;
	}
	
	public void setJumlahSiswa(int jumlahSiswa) {
		this.jumlahSiswa = jumlahSiswa;
	}
	
	public int getTingkat() {
		return tingkat;
	}
	
	public void setTingkat(int tingkat) {
		this.tingkat = tingkat;
	}
	
	
	
	
}

package com.fladioarmandika.tridaya.model;

public class MataPelajaran {
	
	private int id;
	private String namaMataPelajaran;
	private Program program;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNamaMataPelajaran() {
		return namaMataPelajaran;
	}
	public void setNamaMataPelajaran(String namaMataPelajaran) {
		this.namaMataPelajaran = namaMataPelajaran;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}

}

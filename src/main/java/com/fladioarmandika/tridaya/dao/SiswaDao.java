package com.fladioarmandika.tridaya.dao;

import java.text.ParseException;
import java.util.List;

import com.fladioarmandika.tridaya.model.Pembayaran;
import com.fladioarmandika.tridaya.model.Siswa;

public interface SiswaDao {
	
	Siswa getSiswa(int id);
	List<Siswa> getAllSiswa();
	void addSiswa(Siswa siswa) throws ParseException;
	void removeSiswa(int id);
	void updateSiswa(int id, Siswa siswa);
	
	List<Pembayaran> getPembayaran(int id);
	int getJumSiswa();
	int getJumSiswaSD();
	int getJumSiswaSMP();
	int getJumSiswaSMA();
	
	List<Siswa> getListSiswaAvailable(int idKelas);
}

package com.fladioarmandika.tridaya.dao;

import java.text.ParseException;
import java.util.List;

import com.fladioarmandika.tridaya.model.MataPelajaran;
import com.fladioarmandika.tridaya.model.Pengajar;

public interface PengajarDao {
	
	Pengajar getPengajar(int id);
	List<Pengajar> getAllPengajar();
	void addPengajar(Pengajar pengajar) throws ParseException;
	void removePengajar(int id);
	void updatePengajar(int id, Pengajar pengajar);
	
	List<MataPelajaran> getMatpelPengajar();
	
	int getJumPengajar();
	int getJumPengajarAktif();
	
}

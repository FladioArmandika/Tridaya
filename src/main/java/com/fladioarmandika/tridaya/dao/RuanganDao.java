package com.fladioarmandika.tridaya.dao;

import java.util.List;

import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.model.Ruangan;

public interface RuanganDao {
	
	Ruangan getRuangan(int id);
	List<Ruangan> getAllRuangan();
	void addRuangan(Ruangan ruangan);
	void removeRuangan(int id);
	void updateRuangan(int id, Ruangan ruangan);
	
	List<Pembelajaran> getKelasRuanganSelected(int id);
	List<Ruangan> getListRuanganByTanggal(String tanggal);
}

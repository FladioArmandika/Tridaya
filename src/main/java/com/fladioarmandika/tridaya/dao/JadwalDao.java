package com.fladioarmandika.tridaya.dao;

import java.util.List;

import com.fladioarmandika.tridaya.model.Jadwal;

public interface JadwalDao {
	
	Jadwal getJadwal(int id);
	List<Jadwal> getAllJadwal();
	void addJadwal(Jadwal jadwal);
	void removeJadwal(int id);
	void updateJadwal(int id, Jadwal jadwal);
	
}

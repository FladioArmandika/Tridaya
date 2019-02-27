package com.fladioarmandika.tridaya.dao;

import java.util.List;

import com.fladioarmandika.tridaya.model.Petugas;

public interface PetugasDao {

	Petugas getPetugas(int id);
	List<Petugas> getAllPetugas();
	void addPetugas(Petugas petugas);
	void removePetugas(int id);
	void updatePetugas(int id, Petugas petugas);
	
	int getJumPetugas();
}

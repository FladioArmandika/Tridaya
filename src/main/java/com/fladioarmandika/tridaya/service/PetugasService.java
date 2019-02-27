package com.fladioarmandika.tridaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.PetugasDao;
import com.fladioarmandika.tridaya.model.Petugas;

public class PetugasService {
	
	private PetugasDao petugasDao;

	@Autowired
	public void setPetugasDao(PetugasDao petugasDao) {
		this.petugasDao = petugasDao;
	}

	public Petugas getPetugas(int id) {
		return petugasDao.getPetugas(id);
	}
	
	public List<Petugas> getAllPetugas() {
		return petugasDao.getAllPetugas();
	}
	
	public void addPetugas(Petugas petugas) {
		petugasDao.addPetugas(petugas);
	}
	
	public void removePetugas(int id) {
		petugasDao.removePetugas(id);
	}
	
	public void updatePetugas(int id, Petugas petugas) {
		petugasDao.updatePetugas(id, petugas);
	}
	
	public int getJumPetugas() {
		return petugasDao.getJumPetugas();
	}
}

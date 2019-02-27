package com.fladioarmandika.tridaya.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.PengajarDao;
import com.fladioarmandika.tridaya.model.Pengajar;

public class PengajarService {
	
	private PengajarDao pengajarDao;
	
	@Autowired
	public void setPengajarDao(PengajarDao pengajarDao) {
		this.pengajarDao = pengajarDao;
	}

	public Pengajar getPengajar(int id) {
		return pengajarDao.getPengajar(id);
	}
	
	public List<Pengajar> getAllPengajar() {
		return pengajarDao.getAllPengajar();
	}
	
	public void addPengajar(Pengajar pengajar) throws ParseException {
		pengajarDao.addPengajar(pengajar);
	}
	
	public void removePengajar(int id) {
		pengajarDao.removePengajar(id);
	}
	
	public void updatePengajar(int id, Pengajar pengajar) {
		pengajarDao.updatePengajar(id, pengajar);
	}
	
	public int getJumPengajar() {
		return pengajarDao.getJumPengajar();
	}
	
	public int getJumPengajarAktif() {
		return pengajarDao.getJumPengajarAktif();
	}
}

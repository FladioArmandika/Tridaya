package com.fladioarmandika.tridaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.RuanganDao;
import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.model.Ruangan;

public class RuanganService {
	
	private RuanganDao ruanganDao;
	
	@Autowired
	public void setRuanganDao(RuanganDao ruanganDao) {
		this.ruanganDao = ruanganDao;
	}

	public Ruangan getRuangan(int id) {
		return ruanganDao.getRuangan(id);
	}
	
	public List<Ruangan> getAllRuangan() {
		return ruanganDao.getAllRuangan();
	}
	
	public void addRuangan(Ruangan ruangan) {
		ruanganDao.addRuangan(ruangan);
	}
	
	public void removeRuangan(int id) {
		ruanganDao.removeRuangan(id);
	}
	
	public void updateRuangan(int id, Ruangan ruangan) {
		ruanganDao.updateRuangan(id, ruangan);
	}
	
	public List<Pembelajaran> getKelasRuanganSelected(int id) {
		return ruanganDao.getKelasRuanganSelected(id);
	}
	
	public List<Ruangan> getListRuanganByTanggal(String tanggal) {
		return ruanganDao.getListRuanganByTanggal(tanggal);
	}
	
	
}

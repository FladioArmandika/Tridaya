package com.fladioarmandika.tridaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.JadwalDao;
import com.fladioarmandika.tridaya.model.Jadwal;

public class JadwalService {
	
	private JadwalDao jadwalDao;
	
	@Autowired
	public void setJadwalDao(JadwalDao jadwalDao) {
		this.jadwalDao = jadwalDao;
	}
	
	public Jadwal getJadwal(int id) {
		return jadwalDao.getJadwal(id);
	}
	
	public List<Jadwal> getAllJadwal() {
		return jadwalDao.getAllJadwal();
	}
	
	public void addJadwal(Jadwal jadwal) {
		jadwalDao.addJadwal(jadwal);
	}
	
	public void removeJadwal(int id) {
		jadwalDao.removeJadwal(id);
	}
	
	public void updateJadwal(int id, Jadwal jadwal) {
		jadwalDao.updateJadwal(id, jadwal);
	}

}

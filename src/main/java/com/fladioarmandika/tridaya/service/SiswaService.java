package com.fladioarmandika.tridaya.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.SiswaDao;
import com.fladioarmandika.tridaya.model.Pembayaran;
import com.fladioarmandika.tridaya.model.Siswa;

public class SiswaService {
	
	private SiswaDao siswaDao;
	
	@Autowired
	public void setSiswaDao(SiswaDao siswaDao) {
		this.siswaDao = siswaDao;
	}

	public Siswa getSiswa(int id) {
		return siswaDao.getSiswa(id);
	}
	
	public List<Siswa> getAllSiswa() {
		return siswaDao.getAllSiswa();
	}
	
	public void addSiswa(Siswa siswa) {
		try {
			siswaDao.addSiswa(siswa);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public void removeSiswa(int id) {
		siswaDao.removeSiswa(id);
	}
	
	public void updateSiswa(int id, Siswa siswa) {
		siswaDao.updateSiswa(id, siswa);
	}
	
	public List<Pembayaran> getPembayaran(int id) {
		return siswaDao.getPembayaran(id);
	}
	
	public int getJumSiswa() {
		return siswaDao.getJumSiswa();
	}
	
	public int getJumSiswaSD() {
		return siswaDao.getJumSiswaSD();
	}
	
	public int getJumSiswaSMP() {
		return siswaDao.getJumSiswaSMP();
	}
	
	public int getJumSiswaSMA() {
		return siswaDao.getJumSiswaSMA();
	}
	
	public List<Siswa> getListSiswaAvailable(int idKelas) {
		return siswaDao.getListSiswaAvailable(idKelas);
	}
}

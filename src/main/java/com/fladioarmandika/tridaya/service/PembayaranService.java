package com.fladioarmandika.tridaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.PembayaranDao;
import com.fladioarmandika.tridaya.model.Pembayaran;

public class PembayaranService {
	
	private PembayaranDao pembayaranDao;

	@Autowired
	public void setPembayaranDao(PembayaranDao pembayaranDao) {
		this.pembayaranDao = pembayaranDao;
	}

	public Pembayaran getPembayaran(int id) {
		return pembayaranDao.getPembayaran(id); 
	}
	
	public List<Pembayaran> getAllPembayaran() {
		return pembayaranDao.getAllPembayaran();
	}
	
	public void addPembayaran(Pembayaran pembayaran) {
		pembayaranDao.addPembayaran(pembayaran);
	}
	
	public void removePembayaran(int id) { 
		pembayaranDao.removePembayaran(id);
	}
	
	public void updatePembayaran(int id, Pembayaran pembayaran) {
		pembayaranDao.updatePembayaran(id, pembayaran);
	}

}

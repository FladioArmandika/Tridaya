package com.fladioarmandika.tridaya.dao;

import java.util.List;

import com.fladioarmandika.tridaya.model.Pembayaran;

public interface PembayaranDao {
	
	Pembayaran getPembayaran(int id);
	List<Pembayaran> getAllPembayaran();
	void addPembayaran(Pembayaran pembayaran);
	void removePembayaran(int id);
	void updatePembayaran(int id, Pembayaran pembayaran);

}

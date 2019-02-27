package com.fladioarmandika.tridaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.PembelajaranDao;
import com.fladioarmandika.tridaya.model.AbsenRecord;
import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.model.Petugas;
import com.fladioarmandika.tridaya.model.Siswa;

public class PembelajaranService {

	private PembelajaranDao pembelajaranDao;
	
	@Autowired
	public void setPembelajaranDao(PembelajaranDao pembelajaranDao) {
		this.pembelajaranDao = pembelajaranDao;
	}

	public Pembelajaran getPembelajaran(int id) {
		return pembelajaranDao.getPembelajaran(id);
	}
	
	public List<Pembelajaran> getAllPembelajaran() {
		return pembelajaranDao.getAllPembelajaran();
	}
	
	public void addPembelajaran(Pembelajaran pembelajaran) {
		pembelajaranDao.addPembelajaran(pembelajaran);
	}
	
	public void removePembelajaran(int id) {
		pembelajaranDao.removePembelajaran(id);
	}
	
	public void updatePembelajaran(int id, Pembelajaran pembelajaran) {
		pembelajaranDao.updatePembelajaran(id, pembelajaran);
	}
	
	public List<Siswa> getAbsen(int idPembelajaran) {
		return pembelajaranDao.getAbsen(idPembelajaran); 
	}
	
	public void addAbsenSiswa(AbsenRecord absenRecord) {
		pembelajaranDao.addAbsenSiswa(absenRecord);
	}
	
	public void removeAbsenSiswa(int idKelas, int idSiswa) {
		pembelajaranDao.removeAbsenSiswa(idKelas, idSiswa);
	}
	
}

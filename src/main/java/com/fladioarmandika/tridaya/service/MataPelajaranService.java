package com.fladioarmandika.tridaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.MataPelajaranDao;
import com.fladioarmandika.tridaya.model.MataPelajaran;

public class MataPelajaranService {
	
	private MataPelajaranDao mataPelajaranDao;
	
	@Autowired
	public void setMataPelajaranDao(MataPelajaranDao mataPelajaranDao) {
		this.mataPelajaranDao = mataPelajaranDao;
	}
	
	public MataPelajaran getMataPelajaran(int id) {
		return mataPelajaranDao.getMataPelajaran(id);
	}
	
	public List<MataPelajaran> getAllMataPelajaran() {
		return mataPelajaranDao.getAllMataPelajaran();
	}
	
	public void addMataPelajaran(MataPelajaran mataPelajaran) {
		mataPelajaranDao.addMataPelajaran(mataPelajaran);
	}
	
	public void removeMataPelajaran(int id) {
		mataPelajaranDao.removeMataPelajaran(id);
	}
	
	public void updateMataPelajaran(int id,MataPelajaran mataPelajaran) {
		mataPelajaranDao.updateMataPelajaran(id, mataPelajaran);
	}
	
	
}

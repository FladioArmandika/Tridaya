package com.fladioarmandika.tridaya.dao;

import java.util.List;

import com.fladioarmandika.tridaya.model.MataPelajaran;

public interface MataPelajaranDao {

	MataPelajaran getMataPelajaran(int id);
	List<MataPelajaran> getAllMataPelajaran();
	void addMataPelajaran(MataPelajaran mataPelajaran);
	void removeMataPelajaran(int id);
	void updateMataPelajaran(int id,MataPelajaran mataPelajaran);
	
}

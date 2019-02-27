package com.fladioarmandika.tridaya.dao;

import java.util.List;
import com.fladioarmandika.tridaya.model.AbsenRecord;
import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.model.Siswa;

public interface PembelajaranDao {
	
	Pembelajaran getPembelajaran(int id);
	List<Pembelajaran> getAllPembelajaran();
	void addPembelajaran(Pembelajaran pembelajaran);
	void removePembelajaran(int id);
	void updatePembelajaran(int id, Pembelajaran pembelajaran);
	
	List<Siswa> getAbsen(int idPembelajaran);
	void addAbsenSiswa(AbsenRecord absenRecord);
	void removeAbsenSiswa(int idKelas, int idSiswa);
	
}

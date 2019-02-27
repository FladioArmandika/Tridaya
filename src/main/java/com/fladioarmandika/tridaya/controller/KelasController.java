package com.fladioarmandika.tridaya.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fladioarmandika.tridaya.model.AbsenRecord;
import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.model.Pengajar;
import com.fladioarmandika.tridaya.service.MataPelajaranService;
import com.fladioarmandika.tridaya.service.PembelajaranService;
import com.fladioarmandika.tridaya.service.PengajarService;
import com.fladioarmandika.tridaya.service.ProgramService;
import com.fladioarmandika.tridaya.service.RuanganService;
import com.fladioarmandika.tridaya.service.SiswaService;

@Controller
public class KelasController {
	
	@Autowired
	private PembelajaranService pembelajaranService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired 
	private MataPelajaranService mataPelajaranService;
	
	@Autowired
	private PengajarService pengajarSerivce;
	
	@Autowired
	private RuanganService ruanganService;
	
	@Autowired
	private SiswaService siswaService;
	

	@RequestMapping(value="/kelas", method=RequestMethod.GET)
	public ModelAndView getKelasPage(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_kelas.jsp");
		model.addObject("kelas",pembelajaranService.getAllPembelajaran());
		model.addObject("matpel",mataPelajaranService.getAllMataPelajaran());
		model.addObject("program",programService.getAllProgram()); 
		model.addObject("ruangan",ruanganService.getAllRuangan()); 
		model.addObject("pengajar",pengajarSerivce.getAllPengajar());  
		model.setViewName("mainpage");
		return model;
	}
	
	@RequestMapping(value="/kelas/{id}",method=RequestMethod.GET)
	public ModelAndView getKelasViewPage(@PathVariable int id,ModelAndView model) {
		model.addObject("componentUrl","component/cmp_kelas_view.jsp");
		model.addObject("idKelas",id);
		model.addObject("kelas",pembelajaranService.getPembelajaran(id));
		model.addObject("siswa",pembelajaranService.getAbsen(id));
		model.addObject("siswaavail",siswaService.getListSiswaAvailable(id)); 
		model.setViewName("mainpage");
		return model;
	}
	
	@RequestMapping(value="/kelas/{idPembelajaran}/tambah",method=RequestMethod.POST)
	public String addAbsenKelas(@PathVariable int idPembelajaran,@ModelAttribute AbsenRecord absenRecord) {
		pembelajaranService.addAbsenSiswa(absenRecord);
		return "redirect:/kelas/" + idPembelajaran;   
	}
	
	@RequestMapping(value="/kelas/{idKelas}/hapus/{idSiswa}")
	public String removeAbsenKelas(@PathVariable("idKelas") int idKelas, @PathVariable("idSiswa") int idSiswa) {
		pembelajaranService.removeAbsenSiswa(idKelas, idSiswa);
		return "redirect:/kelas/" + idKelas;  
	}
	
	@RequestMapping(value="/kelas/tambah",method=RequestMethod.POST)  
	public String addKelas(@ModelAttribute Pembelajaran pembelajaran){
		pembelajaranService.addPembelajaran(pembelajaran);    
		return "redirect:/kelas"; 
	}
	
	@RequestMapping(value="/kelas/hapus/{id}",method=RequestMethod.GET)
	public String removeKelas(@PathVariable int id) {
		pembelajaranService.removePembelajaran(id);
		return "redirect:/kelas"; 
	}
	
	
	
	
}

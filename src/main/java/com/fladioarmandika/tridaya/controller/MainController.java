package com.fladioarmandika.tridaya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fladioarmandika.tridaya.service.JadwalService;
import com.fladioarmandika.tridaya.service.MataPelajaranService;
import com.fladioarmandika.tridaya.service.PembayaranService;
import com.fladioarmandika.tridaya.service.PembelajaranService;
import com.fladioarmandika.tridaya.service.PengajarService;
import com.fladioarmandika.tridaya.service.PetugasService;
import com.fladioarmandika.tridaya.service.ProgramService;
import com.fladioarmandika.tridaya.service.RuanganService;
import com.fladioarmandika.tridaya.service.SiswaService;

@Controller
public class MainController {
	
	@Autowired
	private JadwalService jadwalService;
	@Autowired
	private MataPelajaranService mataPelajaranService;
	@Autowired
	private PembelajaranService pembelajaranService;
	@Autowired
	private PetugasService petugasService;
	@Autowired
	private ProgramService programService;
	@Autowired
	private RuanganService ruanganService;
	@Autowired
	private SiswaService siswaService;
	@Autowired
	private PengajarService pengajarService;
	@Autowired
	private PembayaranService pembayaranService;
	
	 
	@RequestMapping(value="/home",method=RequestMethod.GET) 
	public ModelAndView getHomePage(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_dashboard.jsp");
		model.addObject("kelas",pembelajaranService.getAllPembelajaran());
		model.addObject("jumSiswa",siswaService.getJumSiswa()); 
		model.addObject("jumSiswaSD",siswaService.getJumSiswaSD());
		model.addObject("jumSiswaSMP",siswaService.getJumSiswaSMP());
		model.addObject("jumSiswaSMA",siswaService.getJumSiswaSMA()); 
		model.addObject("jumPengajar",pengajarService.getJumPengajar());
		model.addObject("jumPengajarAktif",pengajarService.getJumPengajarAktif());
		model.addObject("jumPetugas",petugasService.getJumPetugas());
		model.addObject("pembayaran",pembayaranService.getAllPembayaran());
		model.setViewName("mainpage");
		return model;
	} 
	
	@RequestMapping(value="/settings",method=RequestMethod.GET)
	public ModelAndView getSettingsPage(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_settings.jsp");
		model.setViewName("mainpage");
		return model;
	}
	
	@RequestMapping(value="/help",method=RequestMethod.GET)
	public ModelAndView getHelpPage(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_help.jsp");
		model.setViewName("mainpage");
		return model;
	}

}

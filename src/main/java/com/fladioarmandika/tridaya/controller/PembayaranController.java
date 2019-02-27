package com.fladioarmandika.tridaya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fladioarmandika.tridaya.model.Pembayaran;
import com.fladioarmandika.tridaya.service.PembayaranService;
import com.fladioarmandika.tridaya.service.PetugasService;
import com.fladioarmandika.tridaya.service.SiswaService;

@Controller
public class PembayaranController {

	@Autowired
	private PembayaranService pembayaranService;
	
	@Autowired
	private SiswaService siswaService;
	
	@Autowired
	private PetugasService petugasService;
	
	@RequestMapping(value="/pembayaran", method=RequestMethod.GET)
	public ModelAndView getPembayaran(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_pembayaran.jsp");
		model.addObject("pembayaran",pembayaranService.getAllPembayaran());
		model.addObject("siswa",siswaService.getAllSiswa());
		model.addObject("petugas",petugasService.getAllPetugas());
		model.setViewName("mainpage"); 
		return model;
	}
	
	@RequestMapping(value="/pembayaran/tambah", method=RequestMethod.POST)
	public String addPembayaran(@ModelAttribute Pembayaran pembayaran) {
		pembayaranService.addPembayaran(pembayaran);
		return "redirect:/pembayaran";
	}
	
	
}

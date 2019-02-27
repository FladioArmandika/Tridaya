package com.fladioarmandika.tridaya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fladioarmandika.tridaya.model.Pembelajaran;
import com.fladioarmandika.tridaya.service.PembelajaranService;
import com.fladioarmandika.tridaya.service.RuanganService;

@Controller
public class RuanganController {
	
	@Autowired
	private RuanganService ruanganService;
	
	@Autowired
	private PembelajaranService pembelajaranService;
	
	@RequestMapping(value="/ruangan", method=RequestMethod.GET)
	public ModelAndView getRuangan(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_ruangan.jsp");
		model.addObject("ruangan",ruanganService.getAllRuangan()); 
		model.setViewName("mainpage");
		return model; 
	}
	
	@RequestMapping(value="/ruangan/cari",method=RequestMethod.GET) 
	public ModelAndView getCariRuangan(@ModelAttribute Pembelajaran pembelajaran, ModelAndView model) {
		System.out.println("heii " + pembelajaran.getTanggal());  
		model.addObject("componentUrl","component/cmp_ruangan.jsp");
		model.addObject("ruangan",ruanganService.getListRuanganByTanggal(pembelajaran.getTanggal()));
		model.addObject("tanggalJadwal",pembelajaran.getTanggal());  
		model.setViewName("mainpage");
		return model;  
	}
	
	@RequestMapping(value="/ruangan/{id}",method=RequestMethod.GET)
	public ModelAndView getRuanganViewPage(@PathVariable int id,ModelAndView model) {
		model.addObject("componentUrl","component/cmp_ruangan.jsp");
		model.addObject("ruangan",ruanganService.getAllRuangan()); 
		model.addObject("ruanganselected",ruanganService.getRuangan(id));
		model.addObject("kelasselected",ruanganService.getKelasRuanganSelected(id));
		model.setViewName("mainpage");
		return model;
	}
	
}

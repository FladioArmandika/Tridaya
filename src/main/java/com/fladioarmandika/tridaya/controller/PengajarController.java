package com.fladioarmandika.tridaya.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fladioarmandika.tridaya.model.Pengajar;
import com.fladioarmandika.tridaya.service.PengajarService;

@Controller
public class PengajarController { 
	
	@Autowired
	private PengajarService pengajarService;

	@RequestMapping(value="/pengajar", method=RequestMethod.GET)
	public ModelAndView getPengajar(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_pengajar.jsp");
		model.addObject("pengajar",pengajarService.getAllPengajar());
		model.setViewName("mainpage");
		return model;
	}
	
	@RequestMapping(value="/pengajar/{id}",method=RequestMethod.GET)
	public ModelAndView getPengajarViewPage(@PathVariable int id,ModelAndView model) {
		model.addObject("componentUrl","component/cmp_pengajar_view.jsp");
		model.addObject("pengajar",pengajarService.getPengajar(id));
		model.setViewName("mainpage");
		return model;
	}
	
	@RequestMapping(value="/pengajar/tambah",method=RequestMethod.GET)
	public ModelAndView getPengajarTambahPage(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_pengajar_form.jsp");
		model.addObject("editform","false");
		model.setViewName("mainpage");   
		return model;	
	}
	
	@RequestMapping(value="/pengajar/tambah",method=RequestMethod.POST)
	public String addPengajar(@ModelAttribute Pengajar pengajar) throws ParseException {
		pengajarService.addPengajar(pengajar);
		return "redirect:/pengajar";
	}
	
	@RequestMapping(value="/pengajar/hapus/{id}",method=RequestMethod.GET)
	public String removePengajar(@PathVariable int id) {
		pengajarService.removePengajar(id);
		return "redirect:/pengajar";
	}
	
	@RequestMapping(value="/pengajar/edit/{id}",method=RequestMethod.GET)
	public ModelAndView getPengajarEditPage(@PathVariable int id, ModelAndView model) {
		model.addObject("componentUrl","component/cmp_pengajar_form.jsp");
		model.addObject("editmodel",pengajarService.getPengajar(id));
		model.addObject("editform","true");
		model.setViewName("mainpage");   
		return model;
	}
	
	@RequestMapping(value="/pengajar/edit/{id}",method=RequestMethod.POST)
	public String editPengajar(@PathVariable int id,@ModelAttribute Pengajar pengajar) {
		pengajarService.updatePengajar(id,pengajar);
		return "redirect:/pengajar";
	}
	
}

package com.fladioarmandika.tridaya.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fladioarmandika.tridaya.model.Petugas;
import com.fladioarmandika.tridaya.service.PetugasService;

@Controller
public class PetugasController {
	
	@Autowired
	private PetugasService petugasService;
	
	@RequestMapping(value="/petugas", method=RequestMethod.GET)
	public ModelAndView getPetugas(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_petugas.jsp");
		model.addObject("petugas",petugasService.getAllPetugas());
		model.setViewName("mainpage");
		return model; 
	}
	
	@RequestMapping(value="/petugas/{id}",method=RequestMethod.GET)
	public ModelAndView getPetugasViewPage(@PathVariable int id,ModelAndView model) {
		model.addObject("componentUrl","component/cmp_petugas_view.jsp");
		model.addObject("petugas",petugasService.getPetugas(id));
		model.setViewName("mainpage");
		return model;
	}
	
	@RequestMapping(value="/petugas/tambah",method=RequestMethod.GET)
	public ModelAndView getPetugasTambahPage(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_petugas_form.jsp");
		model.addObject("editform","false");
		model.setViewName("mainpage");   
		return model;	
	}
	
	@RequestMapping(value="/petugas/tambah",method=RequestMethod.POST)
	public String addPetugas(@ModelAttribute Petugas petugas) {
		petugasService.addPetugas(petugas);
		return "redirect:/petugas";
	}
	
	@RequestMapping(value="/petugas/hapus/{id}",method=RequestMethod.GET)
	public String removePetugas(@PathVariable int id) {
		petugasService.removePetugas(id);
		return "redirect:/petugas";
	}
	
	@RequestMapping(value="/petugas/edit/{id}",method=RequestMethod.GET)
	public ModelAndView getPetugasEditPage(@PathVariable int id, ModelAndView model) {
		model.addObject("componentUrl","component/cmp_petugas_form.jsp");
		model.addObject("editmodel",petugasService.getPetugas(id));
		model.addObject("editform","true");
		model.setViewName("mainpage");   
		return model;
	}
	
	@RequestMapping(value="/petugas/edit/{id}",method=RequestMethod.POST)
	public String editPetugas(@PathVariable int id,@ModelAttribute Petugas petugas) {
		petugasService.updatePetugas(id,petugas);
		return "redirect:/petugas";
	}
}

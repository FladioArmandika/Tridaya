package com.fladioarmandika.tridaya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fladioarmandika.tridaya.model.Siswa;
import com.fladioarmandika.tridaya.service.PembayaranService;
import com.fladioarmandika.tridaya.service.ProgramService;
import com.fladioarmandika.tridaya.service.SiswaService;

@Controller
public class SiswaController {
	
	@Autowired
	private SiswaService siswaService;
	@Autowired
	private ProgramService programService;
	@Autowired 
	private PembayaranService pembayaranService;
	
	@RequestMapping(value="/siswa",method=RequestMethod.GET)
	public ModelAndView getSiswaPage(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_siswa.jsp");
		model.addObject("siswa", siswaService.getAllSiswa());
		model.setViewName("mainpage");
		return model;
	} 
	
	@RequestMapping(value="/siswa/{id}",method=RequestMethod.GET)
	public ModelAndView getSiswaViewPage(@PathVariable int id,ModelAndView model) {
		model.addObject("componentUrl","component/cmp_siswa_view.jsp");
		model.addObject("siswa",siswaService.getSiswa(id));
		model.addObject("pembayaran",siswaService.getPembayaran(id));
		model.setViewName("mainpage"); 
		return model;
	}
	
	@RequestMapping(value="/siswa/tambah",method=RequestMethod.GET) 
	public ModelAndView getSiswaTambahPage(ModelAndView model) {
		model.addObject("componentUrl","component/cmp_siswa_form.jsp");
		model.addObject("program",programService.getAllProgram());
		model.addObject("editform","false");
		model.setViewName("mainpage");   
		return model;
	}
	
	@RequestMapping(value="/siswa/tambah",method=RequestMethod.POST)
	public String addSiswa(@ModelAttribute Siswa siswa) {
		//siswa.setProgram(programService.getProgram(Integer.parseInt(idProgram)));
		siswaService.addSiswa(siswa);
		return "redirect:/siswa";
	}
	
	@RequestMapping(value="/siswa/hapus/{id}",method=RequestMethod.GET)
	public String removeSiswa(@PathVariable int id) {
		siswaService.removeSiswa(id);
		return "redirect:/siswa";
	}
	
	@RequestMapping(value="/siswa/edit/{id}",method=RequestMethod.GET)
	public ModelAndView getSiswaEditPage(@PathVariable int id, ModelAndView model) {
		model.addObject("componentUrl","component/cmp_siswa_form.jsp");
		model.addObject("program",programService.getAllProgram());
		model.addObject("editmodel",siswaService.getSiswa(id));
		model.addObject("editform","true");
		model.setViewName("mainpage");   
		return model;
	}
	
	@RequestMapping(value="/siswa/edit/{id}",method=RequestMethod.POST)
	public String editSiswa(@PathVariable int id,@ModelAttribute Siswa siswa) {
		siswaService.updateSiswa(id,siswa);
		return "redirect:/siswa";
	}
	
	
}

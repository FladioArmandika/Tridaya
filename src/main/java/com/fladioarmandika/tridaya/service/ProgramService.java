package com.fladioarmandika.tridaya.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fladioarmandika.tridaya.dao.ProgramDao;
import com.fladioarmandika.tridaya.model.Program;

public class ProgramService {
	
	private ProgramDao programDao;
	
	@Autowired
	public void setProgramDao(ProgramDao programDao) {
		this.programDao = programDao;
	}
	
	public Program getProgram(int id) {
		return programDao.getProgram(id);
	}
	
	public List<Program> getAllProgram() {
		return programDao.getAllProgram();		
	}
	
	public void addProgram(Program program) {
		programDao.addProgram(program);
	}
	
	public void removeProgram(int id) {
		programDao.removeProgram(id);
	}
	
	public void updateProgram(int id, Program program) {
		programDao.updateProgram(id, program);
	}
	
}

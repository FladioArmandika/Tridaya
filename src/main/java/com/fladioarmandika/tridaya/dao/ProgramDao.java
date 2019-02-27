package com.fladioarmandika.tridaya.dao;

import java.util.List;

import com.fladioarmandika.tridaya.model.Program;

public interface ProgramDao {
	
	Program getProgram(int id);
	List<Program> getAllProgram();
	void addProgram(Program program);
	void removeProgram(int id); 
	void updateProgram(int id, Program program);
	
}

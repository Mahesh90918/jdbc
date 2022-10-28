package com.ciq.ems.services;

import java.util.List;

import com.ciq.ems.model.Empolyee;

public interface EmpolyeeService {
	// create update delete, getAll
	void add(Empolyee empolyee);

	void update(Empolyee empolyee);

	int delete(int del);

	List<Empolyee> getAll();
}

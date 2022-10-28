package com.ciq.ems.DataAcessObject;

import java.util.List;

import com.ciq.ems.model.Empolyee;

public interface EmpolyeeDao {

	// create update delete, getAll
	void add(Empolyee empolyee);
	void update(Empolyee empolyee);
	int delete(int id);
	List<Empolyee> getAll();
}

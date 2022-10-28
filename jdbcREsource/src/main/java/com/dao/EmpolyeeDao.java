package com.dao;

import java.util.List;

import com.empolyee.model.Empolyee;

public interface EmpolyeeDao {

	List<Empolyee> add(Empolyee[] empolyee);

	void update(String name, int id);

	int delete(int id);

	List<Empolyee> getAll();
}

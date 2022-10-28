package com.ciq.ems.services;
import java.util.List;
import com.ciq.ems.DataAcessObject.EmpolyeeDaoImpl;
import com.ciq.ems.model.Empolyee;

public class EmpolyeeServiceImple implements EmpolyeeService{
	private static EmpolyeeDaoImpl dao = new EmpolyeeDaoImpl();

	public void add(Empolyee empolyee) {
		dao.add(empolyee);

	}

	public void update(Empolyee empolyee) {
		// TODO Auto-generated method stub

	}

	public int delete(int del) {
		return dao.delete(del);
	}

	public List<Empolyee> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

}

package com.client;

import java.util.List;

import com.dao.EmplImpl;
import com.empolyee.model.Empolyee;

public class EmpolyeeClient {
public static void main(String[] args) {
	Empolyee e1=new Empolyee(01, "siva", 50000);
	Empolyee e2=new Empolyee(02, "mahesh", 34000);
	Empolyee e3=new Empolyee(03, "hari", 45000);
	Empolyee e4=new Empolyee(04, "santhosh", 34000);
	Empolyee e5=new Empolyee(05, "yugundhar", 25000);
//	Empolyee e6=new Empolyee(06, "santhosh", 34000);
//	Empolyee e7=new Empolyee(07, "yugundhar", 25000);
	
	
	Empolyee [] emp= {e1,e2,e3,e4,e5};
//	Empolyee [] emp1= {e6,e7};
	
	
	EmplImpl imp=new EmplImpl();
	List<Empolyee> list =imp.add(emp);
	System.out.println(list);
	
	List<Empolyee> all=imp.getAll();
	for (Empolyee empolyee : all) {
		
		System.out.println(empolyee);
	}
	
}
}

package com.client.copy;

import com.ciq.ems.model.Empolyee;

public class EmpolyeeClient {
public static void main(String[] args) {
	Empolyee e1=new Empolyee(01, "siva", 50000);
	Empolyee e2=new Empolyee(02, "mahesh", 34000);
	Empolyee e3=new Empolyee(03, "hari", 45000);
	Empolyee e4=new Empolyee(04, "santhosh", 34000);
	Empolyee e5=new Empolyee(05, "yugundhar", 25000);
	
	Empolyee [] emp= {e1,e2,e3,e4,e5};
	
	EmpolyeeDaoImpl imp=new EmpolyeeDaoImpl();
	imp.
}
}

package com.ciq.ems.client;

import java.util.ArrayList;
import java.util.List;

import com.ciq.ems.model.Empolyee;
import com.ciq.ems.services.EmpolyeeServiceImple;

public class EmpolyeeClint {
	public static void main(String[] args) {
		EmpolyeeServiceImple ser = new EmpolyeeServiceImple();
		// Empolyee emp = new Empolyee(20, "mahesh", 25000.00);
		Empolyee emp = new Empolyee();
		List<Empolyee> list = new ArrayList<Empolyee>();
		list.add(new Empolyee(26, "siva", 50001));
		list.add(new Empolyee(22, "paravathi", 50000));
		list.add(new Empolyee(23, "vinayaka", 49999));
		list.add(new Empolyee(24, "subramanya", 49998));
		list.add(new Empolyee(25, "harinaryana", 49997));
		EmpolyeeServiceImple esi = new EmpolyeeServiceImple();
		Empolyee[] s = new Empolyee[list.size()];
		list.toArray(s);
		for (Empolyee string : s) {

			ser.add(string);
			
			//System.out.println(string);
		}
		System.out.println(esi);
//		List<Empolyee> list = esi.getAll();
//		for (Empolyee empolyee : list) {
//			System.out.println(empolyee);
//		}

//		esi.delete(15);
//		System.out.println(esi);
	}
}

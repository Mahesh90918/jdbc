package com.ciq.cust.util;

import java.sql.Blob;
import java.util.Date;

import com.mysql.cj.jdbc.Clob;

public class Customer {
	private int id;
	private String conceptName;
	private Clob file;
	private Blob logo;
	private Date creation_date;
	private String comments;
public Customer() {
	// TODO Auto-generated constructor stub
}
	public Customer(int id, String conceptName, Clob file, Blob logo, Date creation_date, String comments) {
		super();
		this.id = id;
		this.conceptName = conceptName;
		this.file = file;
		this.logo = logo;
		this.creation_date = creation_date;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getConceptName() {
		return conceptName;
	}

	public void setConceptName(String conceptName) {
		this.conceptName = conceptName;
	}

	public Clob getFile() {
		return file;
	}

	public void setFile(Clob file) {
		this.file = file;
	}

	public Blob getLogo() {
		return logo;
	}

	public void setLogo(Blob logo) {
		this.logo = logo;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", conceptName=" + conceptName + ", file=" + file + ", logo=" + logo
				+ ", creation_date=" + creation_date + ", comments=" + comments + "]";
	}

}

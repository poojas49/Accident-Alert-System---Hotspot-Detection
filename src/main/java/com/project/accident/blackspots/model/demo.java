package com.project.accident.blackspots.model;
import javax.persistence.*;

@Entity
@Table(name="demons")
public class demo {
	
	@Id
	private int ID;
	private String fname;
	
	public int getId() {
		return ID;
	}
	public void setId(int ID) {
		this.ID = ID;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}

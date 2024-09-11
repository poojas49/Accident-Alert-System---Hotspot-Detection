package com.project.accident.blackspots.model;

import java.math.BigInteger;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	int userid;
	@Column(name="first_name")
	String first_name;
	@Column(name="last_name")
	String last_name;
	@Column(name="account_number")
	BigInteger account_number;
	@Column(name="email")
	String email;
	@Column(name="pass_word")
	String pass_word;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public BigInteger getAccount_number() {
		return account_number;
	}
	public void setAccount_number(BigInteger account_number) {
		this.account_number = account_number;
	}
	public String getPass_word() {
		return pass_word;
	}
	public void setPass_word(String pass_word) {
		this.pass_word = pass_word;
	}
}

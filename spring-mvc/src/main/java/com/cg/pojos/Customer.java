package com.cg.pojos;

import java.util.Date;

//JPA
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity // mandatory
@Table(name = "customer")
public class Customer {

	private Integer id;
	private String name, email, password, role;
	private double regAmount;
	private Date regDate;

	public Customer() {
		System.out.println("Inside Customer() contr.");
	}

	public Customer(Integer id, String name, String email, String password, String role, double regAmount,
			Date regDate) {
		System.out.println("Inside Customer() parameterized contr.");
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}

	@Id // mandatory
	@GeneratedValue(strategy = GenerationType.IDENTITY) // suited for MySQL
	@Column(name = "cust_id")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 20, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(columnDefinition = "double(6,1)", name = "reg_amt")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "reg_dt")
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Customer [Id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", role="
				+ role + ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}
}
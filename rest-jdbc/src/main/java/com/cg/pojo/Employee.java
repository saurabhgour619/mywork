package com.cg.pojo;

import org.json.simple.JSONArray;

public class Employee {
	private String id;
	private String name;
	private JSONArray address;

	public Employee() {
	}

	public Employee(String id, String name, JSONArray address) {
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JSONArray getAddress() {
		return address;
	}

	public void setAddress(JSONArray address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

}

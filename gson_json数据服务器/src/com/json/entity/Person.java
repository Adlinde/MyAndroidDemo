package com.json.entity;
public class Person {
	
	
	private int id;
	
	private String name;
	
	private String adrees;
	
	public Person() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdrees() {
		return adrees;
	}

	public void setAdrees(String adrees) {
		this.adrees = adrees;
	}

	public Person(int id, String name, String adrees) {
		super();
		this.id = id;
		this.name = name;
		this.adrees = adrees;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", adrees=" + adrees + "]";
	}
	
	

}

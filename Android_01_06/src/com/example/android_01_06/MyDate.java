package com.example.android_01_06;

import java.io.Serializable;

public class MyDate implements Serializable {

	private static final long serialVersionUID = 602695711571813291L;

	private String name;
	
	private int age;
	
	

	@Override
	public String toString() {
		return "MyDate [name=" + name + ", age=" + age + "]";
	}

	public MyDate(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	

}

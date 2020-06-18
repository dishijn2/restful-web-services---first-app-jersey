package com.api.demorestful;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	private String name;
	private int points;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", points=" + points + "]";
	}
	
}

package com.example.demo.model;

public class Cat {
	String name;
	Double weight;
	public Cat() {
		
	}
	public Cat(String name, Double weight) {
		super();
		this.name = name;
		this.weight = weight;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", weight=" + weight + "]";
	}
	
	
	
}

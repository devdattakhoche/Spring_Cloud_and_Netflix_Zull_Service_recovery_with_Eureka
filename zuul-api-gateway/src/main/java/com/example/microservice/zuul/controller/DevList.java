package com.example.microservice.zuul.controller;

public class DevList {
	private int key;
	private String name;
	
	public DevList() {
		
	}
	
	public int getKey() {
		return key;
	}
	
	public void setKey(int key) {
		this.key = key;
	}
	
	public DevList(int key, String name) {
		super();
		this.key = key;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}

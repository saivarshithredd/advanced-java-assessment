package com.example.demo.model;

public class Movie {

	private int id;
	private String name;
	private String language;
	private double price;

	public Movie(int id, String name, String language, double price) {
		this.id = id;
		this.name = name;
		this.language = language;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLanguage() {
		return language;
	}

	public double getPrice() {
		return price;
	}

}
package com.bookStore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MyBooks")
public class MyBookList {

	@Id
	private int id;
	private String name;
	private String author;
	private String price;
	private String genre; // New field for genre
	private int publicationYear; // New field for publication year

	// Default constructor
	public MyBookList() {
		// This constructor is required by Hibernate
	}

	// Parameterized constructor
	public MyBookList(int id, String name, String author, String price, String genre, int publicationYear) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
		this.genre = genre;
		this.publicationYear = publicationYear;
	}

	// Getters and setters

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}
}
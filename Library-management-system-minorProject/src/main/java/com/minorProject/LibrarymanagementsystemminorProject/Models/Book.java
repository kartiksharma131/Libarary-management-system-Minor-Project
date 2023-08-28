package com.minorProject.LibrarymanagementsystemminorProject.Models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	
	/*
	 * different relations 
	 * 1) many to one
	 * 2) many to many
	 * 3) one o many
	 * 4) one to one 
	 * 
	 * ways to handle relationship
	 * 1) unidirectional  -- having only one foreign key attribute in current class
	 * 2) bidirectional
	 */
	
	
	public int getId() {
		return id;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="bookname")
	private String name;
	private int cost;
	@CreationTimestamp
	private Date updatedOn;
	@CreationTimestamp
	private Date createdOn;
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value="bookList")
	private Author author;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value="bookList")
	private User user;
	
	@Enumerated(value=EnumType.STRING)
	private Genre genre;
	
	@OneToMany(mappedBy = "book")
	@JsonIgnoreProperties(value="book")
	private List<Transaction> transactionList;
	
	
}

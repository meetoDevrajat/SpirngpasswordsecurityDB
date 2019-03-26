package com.cts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
/*CREATE TABLE `book` (
		 `bookid` INTEGER NOT NULL AUTO_INCREMENT,
		 `title` VARCHAR(200),
		 `author` VARCHAR(100),
		`price` DECIMAL(5,2),
		 PRIMARY KEY (`bookid`)
		);*/
//import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "book_hiber")
public class Book{
	 @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name = "bookid")
	 int id;
	 
	 @Column(name = "TITLE")
	   @Size(max = 50, min = 3) //, message = "{user.name.invalid}")
      String title;
	 
	 @Column(name = "AUTHOR", unique = true)
     String author;
	 
	 @Column(name = "PRICE")
     float price;
    
	 @Column(name = "password")
	 @Size(min=2,max=100)
    String password;
	 
    //Default Constructor
    public Book() {}    
    //Paramatized constructor
	public Book(int id) {
		super();this.id = id;
	}
	//Paramatized constructor
	public Book(int id, String title, String author, float price) {
	        this(title, author, price);
	        this.id = id;
	    }
	//Paramatized constructor     
	public Book(String title, String author, float price) {
	        this.title = title;
	        this.author = author;
	        this.price = price;
	    }
	// Getter Setter
	public int getId() {return id;	}
	public void setId(int id) {	this.id = id;}
	public String getTitle() {	return title;}
	public void setTitle(String title) {this.title = title;	}
	public String getAuthor() {	return author;	}
	public void setAuthor(String author) {this.author = author;	}
	public float getPrice() {	return price;}
	public void setPrice(float price) {	this.price = price;}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
}

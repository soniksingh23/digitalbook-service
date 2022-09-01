package com.book.bookservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	
	private String category;
	
	private Integer price;
	
	private String author;
	
	private String publisher;
	
	private String publishedDate;
	
	private String contents;
	
	private String imageURL;
	public Book(Integer id, String title, String category, Integer price, String author, String publisher,
			String publishedDate, String contents, String imageURL, boolean active) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.contents = contents;
		this.imageURL = imageURL;
		this.active = active;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}


	private boolean active;
	public Book() {
		super();
		
	}

	public Book(Integer id, String title, String category, Integer price, String author, String publisher,
			String publishedDate, String contents, boolean active) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.contents = contents;
		this.active = active;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", category=" + category + ", price=" + price + ", author="
				+ author + ", publisher=" + publisher + ", publishedDate=" + publishedDate + ", contents=" + contents
				+ ", imageURL=" + imageURL + ", active=" + active + ", getId()=" + getId() + ", getTitle()="
				+ getTitle() + ", getCategory()=" + getCategory() + ", getPrice()=" + getPrice() + ", getAuthor()="
				+ getAuthor() + ", getPublisher()=" + getPublisher() + ", getPublishedDate()=" + getPublishedDate()
				+ ", getContents()=" + getContents() + ", isActive()=" + isActive() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}

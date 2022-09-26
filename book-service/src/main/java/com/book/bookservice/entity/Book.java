package com.book.bookservice.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.book.bookservice.enums.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Soni Kumari Book Entity Class
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "book")
//@where(!=y)
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String title;

	private BigDecimal price;

	private String publisher;

	private Date publishedDate;

	private String contents;

	private String imageURL;

	private boolean active;
	
	private boolean deleted;
	
	@Enumerated(EnumType.STRING)
	private Category category;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id")
	private Author author;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "reader_id")
	private Author reader;

}





























//@OneToOne
//@JoinColumn(name="reader_id", nullable=false)
//private Reader reader;

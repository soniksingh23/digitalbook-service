package com.book.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookservice.entity.Book;
import com.book.bookservice.service.BookService;
@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookRestController {
 
	@Autowired
	private BookService bookservice;
	
	@GetMapping("/home")
	  public String home() {
		  return "You are an Author!";
	  }
	
	//To get the book details
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookservice.getBooks();
		
	}
	//To get book by its id
	@GetMapping("/books/{id}")
	public Book getOneBook(@PathVariable Integer id) {
		return this.bookservice.getBookById(id);
	}
	
	//To add Book
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		return this.bookservice.addBook(book);
	}
	
	//To Search Book searchBooksByCategoryAuthorPricePublisher
	@GetMapping("/books/search")
	List<Book> searchBooks(@RequestParam String category, @RequestParam String author, @RequestParam int price,@RequestParam String publisher){
		//Using Query
		//List<Book> listOfBooks = bookservice.searchBooks(category, author, price, publisher);  
		
		List<Book> listOfBooks = bookservice.searchBooksByCategoryAuthorPricePublisher(category, author, price, publisher);
		System.out.println(listOfBooks);
		return listOfBooks;
	}
	
	
	
}

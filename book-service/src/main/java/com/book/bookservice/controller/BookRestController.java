package com.book.bookservice.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.bookservice.entity.Book;
import com.book.bookservice.service.AuthorService;
import com.book.bookservice.service.BookService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Soni Kumari BookRestController Class contains below methods:
 * 
 *         getBooks method To get all the book details
 *         getOneBook To get one book by its id 
 *         saveBook To save book Details 
 *         searchBooks To Search
 *         Book by Category, author,price and publisher
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api/v1/digitalbooks")
public class BookRestController {

	@Autowired
	private BookService bookservice;

	@Autowired
	private AuthorService authorService;

	@GetMapping("/home")
	public String home() {
		return "You are an Author!";
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {

		ResponseEntity<List<Book>> response;
		List<Book> listOfBooks = this.bookservice.getBooks();
		response = new ResponseEntity<>(listOfBooks, HttpStatus.OK);
		return response;
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getOneBook(@PathVariable Integer id) {
		ResponseEntity<Book> response;
		Book book = this.bookservice.getBookById(id);
		log.debug("Inside getOneBook\n" + book);
		response = new ResponseEntity<>(book, HttpStatus.OK);
		return response;
	}

	@PostMapping("/author/books")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		ResponseEntity<Book> response;
		Book authorBook = authorService.addAuthor(book);
		log.debug("Inside Save Book \n " + authorBook);
		response = new ResponseEntity<>(authorBook, HttpStatus.OK);
		return response;
	}

	@GetMapping("/books/search")
	public ResponseEntity<List<Book>> searchBooks(@RequestParam String category, @RequestParam String author,
			@RequestParam BigDecimal price, @RequestParam String publisher) {
		ResponseEntity<List<Book>> response;
		List<Book> listOfBooks = bookservice.searchBooksByCategoryAuthorPricePublisher(category, author, price,
				publisher);
		response = new ResponseEntity<>(listOfBooks, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/books/{id}")
	void deleteUser(@PathVariable("id") Integer bookid) {
		log.debug("Inside DeleteUser Method!!");
		bookservice.delete(bookid);
	}

}






















































/*
 * @GetMapping("/books/{id}") public Book getOneBook(@PathVariable Integer id) {
 * return this.bookservice.getBookById(id); }
 */

/*
 * @PostMapping("/author/books") public Book saveBook(@RequestBody Book book) {
 * Book author1 = authorService.addAuthor(book);
 * log.debug("author service \n "+author1); return author1; }
 */

/*
 * @GetMapping("/books/search") List<Book> searchBooks(@RequestParam String
 * category, @RequestParam String author, @RequestParam BigDecimal
 * price,@RequestParam String publisher){ List<Book> listOfBooks =
 * bookservice.searchBooksByCategoryAuthorPricePublisher(category, author,
 * price, publisher); log.debug("Inside searchBooks in BookRestController..");
 * return listOfBooks; }
 */

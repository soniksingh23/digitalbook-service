package com.book.bookservice.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.book.bookservice.entity.Author;
import com.book.bookservice.entity.Book;
import com.book.bookservice.enums.Category;
import com.book.bookservice.service.BookService;



@ExtendWith(MockitoExtension.class)
class BookControllerTest {
	@Mock
	BookService service;
	@InjectMocks
	BookRestController bookRestController;

	 Category category;
	 
	@Test
	void testSaveBook1() {
		Book book = new Book();//.setId(1);
		BigDecimal price = BigDecimal.valueOf(500.4);
		Author author = new Author();
		book.setId(1);
		book.setAuthor(author);
		book.setCategory(category);
		book.setContents("");
		book.setPrice(price);
		when(service.addBook(book)).thenReturn(book);// mocking
		ResponseEntity<Book> book1 = bookRestController.saveBook(book);
		assertEquals(book, book1);
	}

	
	@Test
	void testSearchBooks() {
		
		Book book = new Book();
		List<Book> listOfBooks = new ArrayList<>();
		listOfBooks.add(book);
		String category="COMIC";
		String author="John1";
		BigDecimal price= new BigDecimal(1.0);
		String publisher="Publisher2";
	//	when(service.searchBooks(category, author, price, publisher)).thenReturn(listOfBooks);
		ResponseEntity<List<Book>> actual= bookRestController.searchBooks(category, author, price, publisher);
		assertEquals(listOfBooks, actual.getBody());
	}


	
	
	
}

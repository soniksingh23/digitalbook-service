package com.book.bookservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.bookservice.entity.Author;
import com.book.bookservice.entity.Book;
import com.book.bookservice.entity.User;
import com.book.bookservice.enums.Category;
import com.book.bookservice.repository.BookRepository;
import com.book.bookservice.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {
	@InjectMocks
	BookService service;
	
	@Mock
	BookRepository repository;
	
	@Test
	public void testGetBooks() {
		Book book = new Book();
		book.setId(1);
		book.setTitle("Mahatma Gandhi");
		when(repository.save(book)).thenReturn(book);//mock
		service.addBook(book);
		assertEquals(1,	book.getId());
	}

	@Test
	void testSearchBooks() {
		List<Book> books = new ArrayList<>();
		Book book = getBooks();
		String title = "book1";
		String category="Adventure";
		String author="David";
		BigDecimal price=new BigDecimal(1.0);
		String publisher="ABC Publisher";
		books.add(book);
		when(repository.findAll()).thenReturn(books);
		Iterable<Book> actual = service.searchBooksByCategoryAuthorPricePublisher( category, author, price, publisher);
		assertEquals(books,	actual);
	}
	
	

	Book getBooks() {
		Book book = new Book();
		Author author= new Author();
		book.setTitle("book1");
		book.setCategory(Category.INSPIRATIONAL);
		book.setPrice(new BigDecimal(1.0));
		book.setAuthor(author);
		//book.setAuthor(author.setName("author1"));
		book.setPublisher("ABC Publisher");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate publishedDate = LocalDate.parse("23/09/2022", formatter);
		//book.setPublishedDate(publishedDate);
		//book.setPublishedDate(publishedDate);
		book.setContents("This is book1 content");
		book.setActive(true);
		return book;
	}
	

	@Test
	void testGetAuthorBook2() {
		Optional<Book> book = Optional.empty();
		Book book1 = null;
		String userName = "David1";
		Integer bookId = 1;
		when(repository.findById(bookId )).thenReturn(book);
		Book actual = service.getBookById(bookId);
		//Book actual = service.getAuthorBook(bookId, userName);
		assertEquals(book1, actual);
	}

}

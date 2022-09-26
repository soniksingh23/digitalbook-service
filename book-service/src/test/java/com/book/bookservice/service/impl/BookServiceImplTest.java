package com.book.bookservice.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.book.bookservice.entity.Book;
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

	
	

}

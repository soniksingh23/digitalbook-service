package com.book.bookservice.service;

import java.math.BigDecimal;
import java.util.List;

import com.book.bookservice.entity.Book;

public interface BookService {

	public List<Book> getBooks();

	public Book getBookById(Integer id);

	public Book addBook(Book book);

	public List<Book> searchBooksByCategoryAuthorPricePublisher(String category, String author, BigDecimal price,
			String publisher);

	public void delete(Integer userid);

}

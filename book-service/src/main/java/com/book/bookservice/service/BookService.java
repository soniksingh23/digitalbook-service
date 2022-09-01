package com.book.bookservice.service;

import java.util.List;

import com.book.bookservice.entity.Book;

public interface BookService {
	
	public List<Book> getBooks();

	public Book getBookById(Integer id);

	public Book addBook(Book book);

	public List<Book> searchBooks(String category, String author, int price, String publisher);

	List<Book> searchBooksByCategoryAuthorPricePublisher(String category, String author, int price, String publisher);

}

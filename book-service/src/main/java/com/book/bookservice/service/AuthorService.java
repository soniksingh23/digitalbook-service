package com.book.bookservice.service;

import com.book.bookservice.entity.Author;
import com.book.bookservice.entity.Book;

public interface AuthorService {

	public Author getAuthorById(Integer id);

	public Book addAuthor(Book book);

}





















//public Book getBookById(Integer id);

//public Author addAuthor();
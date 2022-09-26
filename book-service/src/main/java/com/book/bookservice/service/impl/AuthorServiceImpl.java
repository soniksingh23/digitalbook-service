package com.book.bookservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.book.bookservice.entity.Author;
import com.book.bookservice.entity.Book;
import com.book.bookservice.repository.AuthorRepository;
import com.book.bookservice.repository.BookRepository;
import com.book.bookservice.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	@Override
	public Author getAuthorById(Integer id) {

		log.debug("Inside getAuthorById service method");
		return authorRepository.findAllById(id);
	}

	@Override
	public Book addAuthor(Book book) {

		log.debug("Inside addAuthor service method");
		return bookRepository.save(book);
	}

}


















/*
 * @Override //public Author addAuthor(Author author) { public Book
 * addAuthor(Book book) { //return authorRepository.save(author);
 * log.debug("Inside addAuthor service method"); return
 * bookRepository.save(book); }
 */
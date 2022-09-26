package com.book.bookservice.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookservice.entity.Book;
import com.book.bookservice.repository.BookRepository;
import com.book.bookservice.service.BookService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Soni Kumari BookServiceImpl Class
 *
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> getBooks() {

		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Integer id) {

		return bookRepository.findById(id).get();
	}

	@Override
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public List<Book> searchBooksByCategoryAuthorPricePublisher(String category, String author, BigDecimal price,
			String publisher) {

		List<Book> searchList = new ArrayList<>();
		Iterator<Book> lisOfBooks = bookRepository.findAll().iterator();
		while (lisOfBooks.hasNext()) {
			Book book = lisOfBooks.next();
			if (book.getCategory().equals(category) ||

					book.getAuthor().getName().equals(author) || book.getPrice().equals(price)
					|| book.getPublisher().equalsIgnoreCase(publisher)) {

				searchList.add(book);
			}
		}
		log.debug("Inside searchBooksByCategoryAuthorPricePublisher \n" + searchList);
		return searchList;

	}

	public void delete(Integer bookid) {
		log.debug("Inside Delete method!");
		//bookRepository.deleteById(bookid);
		Optional<Book> deleteId= bookRepository.findById(bookid);
		if (deleteId.isPresent()) {
			Book book= deleteId.get();
			book.setDeleted(true);
			bookRepository.save(book);
		}
		
	}
	
	
	
}





















/*
 * @Override public List<Book> searchBooks(String category, String author,
 * BigDecimal price, String publisher) {
 * 
 * List<Book> searchList= new ArrayList<>(); //searchList =
 * bookRepository.searchBooks(publisher); searchList =
 * bookRepository.searchBooks(category, author,price,publisher);
 * log.info("Search Value in Impl is :"+searchList); return searchList; }
 */
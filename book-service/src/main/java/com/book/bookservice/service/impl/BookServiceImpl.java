package com.book.bookservice.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.bookservice.entity.Book;
import com.book.bookservice.repository.BookRepository;
import com.book.bookservice.service.BookService;
@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	List<Book> bookList;

	public BookServiceImpl() {
		bookList= new ArrayList<>();
//		bookList.add(new Book(id,title,category,price,author,publisher,publishedDate,contents))
		bookList.add(new Book(11,"MySuccess","Motivational",500,"Raj Morgon","ABCH","23/09/2018","This is my first book", true));
		bookList.add(new Book(12,"MyJourney","Motivational",550,"Raj Morgon","ABCH","23/09/2018","This is my 2nd book", true));
	}
	
	@Override
	public List<Book> getBooks() {
        return bookRepository.findAll();
		//return bookList;
	}

	@Override
	public Book getBookById(Integer id) {
		Book book= null;
		
		for(Book bookOne:bookList) {
		//for(Book bookOne:bookRepository) {
			if(bookOne.getId()==id) {
				book= bookOne;
				break;
			}
		}
		//return bookRepository.findById(id);
		return book;
	}

	@Override
	public Book addBook(Book book) {
		//bookList.add(book);
		 return bookRepository.save(book);
		//return book;
	}

	@Override
	public List<Book> searchBooks(String category, String author, int price, String publisher) {

		List<Book> searchList= new ArrayList<>();
		
		searchList = bookRepository.searchBooks(publisher);
		System.out.println("Search Value in Impl is :"+searchList);
		return searchList;
	}

	@Override
	public List<Book> searchBooksByCategoryAuthorPricePublisher(String category, String author, int price, String publisher) {
	
		List<Book> searchList= new ArrayList<>();
		Iterator<Book> lisOfBooks= bookRepository.findAll().iterator();
		while(lisOfBooks.hasNext()) {
			Book book = lisOfBooks.next();
			if(book.getCategory().equalsIgnoreCase(category) || 
					book.getAuthor().equalsIgnoreCase(author) ||
							book.getPrice().equals(price)||
							book.getPublisher().equalsIgnoreCase(publisher)){
				//searchList.add(book);
				searchList.add(book);
							}
		}
		return searchList;
		
	}

	
}

package com.book.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.bookservice.entity.Book;
/**
 * 
 * @author Soni Kumari
 * BookRepository Class
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	


}



























//sList<Book> searchBooks(String category, String author, BigDecimal price, String publisher);
//TODO : "Use String Buffer"
	/*
	@Query(value="SELECT b FROM Book b WHERE \n"+
	        "b.category LIKE CONCAT('%',:query,'%')\n"+
	        "Or b.author LIKE CONCAT('%',:query,'%')\n"+
	        "Or b.price LIKE CONCAT('%',:query,'%')\n"+
	        "Or b.publisher LIKE CONCAT('%',:query,'%')"
			
	)
	
	List<Book> searchBooks(String query); */

	
	//List<Book> searchBooks(String category, String author, BigDecimal price, String publisher);
	//List<Book> searchBooks(String publisher, String category, String author, String publisher2);
	
	//Book findById(Integer id);
	
//	List<Book> fetchByCategoryOrAuthor(String category, String author);

//	select * FROM books b 
//	WHERE b.category="Inspiration"or b.author="John William"or b.price =500 or b.publisher="ABC enterjak";
	//List<Book> fetchByCategoryOrAuthor(String category, String author);
package com.book.bookservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.bookservice.entity.Author;
import com.book.bookservice.entity.Book;

/**
 * 
 * @author Soni Kumari
 * Author Repository Class
 *
 */
public interface AuthorRepository extends JpaRepository<Book, Integer>{

	Author findAllById(Integer id);
	
	Optional<Book> findById(Integer id);

	Author save(Author author);

}

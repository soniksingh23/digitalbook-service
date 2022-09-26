package com.book.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.bookservice.entity.Book;

/**
 * 
 * @author Soni Kumari
 * Reader Repository Class
 *
 */
public interface ReaderRepository extends JpaRepository<Book, Integer>{

}

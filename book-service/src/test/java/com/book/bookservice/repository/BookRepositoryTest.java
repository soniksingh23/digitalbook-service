package com.book.bookservice.repository;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class BookRepositoryTest {

	@Autowired
	private BookRepository bookRepository;
	/*
	@Test
	void searchBooks(String query){
//		Book book = new Book();
//		book.setId(1);
//		when(service.addBook(book)).thenReturn(book);// mocking
//		Book book1 = controller.addBook(book);
		
//		assertEquals(book, book1);
		//bookList= new ArrayList<>();
//		bookList.add(new Book(id,title,category,price,author,publisher,publishedDate,contents))
//		bookList.add(new Book(12,"MyJourney","Motivational",550,"Raj Morgon","ABCH","23/09/2018","This is my 2nd book", true));
		String title;
		int id;
		String category;
		int price;
		String author;
		String publisher;
		String publishedDate;
		String contents;
		boolean active;
		Book book = new Book(id: 1, title: "Mahatma Gandhi",category: "MOTIVATIONAL",price: 400,author:" ",publisher: "Publisher1",publishedDate: "2022-09-24", contents: "Life History", active: true);
		
		//Book book = new Book(1,"Journey Of Newton","Inspiration",400,"John William","ABC enterjak","22/09/2019","Life History", true);
		bookRepository.save(book);
		List<Book> actualResult = bookRepository.searchBooks("Inspiration");
		assertEquals(book, actualResult);
		
	}*/
	
}

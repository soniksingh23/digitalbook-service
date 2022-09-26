package com.book.bookservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Soni Kumari
 * Book Controller Class
 *
 */
@Controller 
@RequestMapping("/mybook")
@ResponseBody
public class BookController {

	 @RequestMapping("/")
	 public String getBook() {
		  return "You are an Author!";
	  }
}

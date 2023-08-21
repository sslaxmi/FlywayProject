package com.spring.flyway.api.service;

import java.util.List;

import com.spring.flyway.api.model.Book;

public interface BookService {

	Book createBook(Book book);
	
	Book getBookById(Long bookId);
	
	List<Book> getAllBooks();
	
	Book updateBook(Book book);
	
	void deleteBook(Long bookId);
	
}

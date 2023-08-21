package com.spring.flyway.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.flyway.api.model.Book;

@Service
public class BookImplementation implements BookService {

	@Autowired
	public com.spring.flyway.api.repository.BookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public Book getBookById(Long bookId) {
		Optional<Book> optionalBook=bookRepository.findById(bookId);
		return optionalBook.get();
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book updateBook(Book book) {
		Book existingBook=bookRepository.findById(book.getId()).get();
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		Book updateBook=bookRepository.save(existingBook);
		return updateBook;
	}

	@Override
	public void deleteBook(Long bookId) {
       bookRepository.deleteById(bookId);		
	}
	
}

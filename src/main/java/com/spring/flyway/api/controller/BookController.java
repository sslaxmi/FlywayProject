package com.spring.flyway.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.flyway.api.model.Book;
import com.spring.flyway.api.service.BookService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    // Define CRUD endpoints using bookRepository
    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book){
    	Book savedBook=bookService.createBook(book);
    	return new ResponseEntity<>(savedBook,HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long bookId){
    	Book book=bookService.getBookById(bookId);
    	return new ResponseEntity<>(book,HttpStatus.OK);
    }
    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
    	List<Book> bookList=bookService.getAllBooks();
    	return new ResponseEntity<>(bookList,HttpStatus.OK);
    }
    
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable("id") Long bookId,@RequestBody Book book){
    	book.setId(bookId);
    	Book Updatebook=bookService.updateBook(book);
    	return new ResponseEntity<>(Updatebook,HttpStatus.OK);
    }
    // Additional endpoints for your stored procedure
}

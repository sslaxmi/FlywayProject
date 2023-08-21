package com.spring.flyway.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.flyway.api.model.Book;


public interface BookRepository extends JpaRepository<Book, Long> {
}


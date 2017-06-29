package com.bookshop.repository;

import com.bookshop.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

  Book findByAuthor(String author);

  Book findByName(String name);
}

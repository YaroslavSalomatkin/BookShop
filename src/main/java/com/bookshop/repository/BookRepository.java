package com.bookshop.repository;

import com.bookshop.model.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

  public Book findAuthor(String author);

  public Book findBookName(String bookName);
}

package com.bookshop.controller;

import com.bookshop.exceptions.BookAlreadyExistsException;
import com.bookshop.exceptions.BookNotFoundException;
import com.bookshop.model.Book;
import com.bookshop.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

  @Autowired
  private BookService bookService;

  @RequestMapping("/all")
  public List<Book> getAll() {
    return bookService.getAll();
  }

  @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
  public Book getBook(@PathVariable("bookId") int bookId) throws BookNotFoundException {
    return bookService.getBook(bookId);
  }

  @RequestMapping(value = "/addBook", method = RequestMethod.POST)
  public Book addBook(@RequestBody Book book) throws BookAlreadyExistsException {
    return bookService.addBook(book);
  }

  @RequestMapping(value = "/updateBook", method = RequestMethod.PUT)
  public Book updateBook(@RequestBody Book book) throws BookNotFoundException {
    return bookService.updateBook(book);
  }

  @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
  public void deleteBook(@PathVariable("bookId") int bookId) throws BookNotFoundException {
    bookService.deleteBook(bookId);
  }
}


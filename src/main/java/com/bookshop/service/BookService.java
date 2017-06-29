package com.bookshop.service;

import com.bookshop.exceptions.BookAlreadyExistsException;
import com.bookshop.exceptions.BookNotFoundException;
import com.bookshop.model.Book;
import com.bookshop.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public List<Book> getAll() {
    return (List<Book>) bookRepository.findAll();
  }

  public Book getBook(int id) throws BookNotFoundException {
    if (bookRepository.findOne(id) == null) {
      throw new BookNotFoundException();
    }
    return bookRepository.findOne(id);
  }

  public Book addBook(Book book) throws BookAlreadyExistsException {
    if (bookRepository.findByAuthor(book.getAuthor()) == null
        && bookRepository.findByName(book.getBookName()) == null) {
      return bookRepository.save(book);
    } else {
      throw new BookAlreadyExistsException();
    }
  }

  public Book updateBook(Book book) throws BookNotFoundException {
    Book bookFromDataBase = bookRepository.findOne(book.getId());
    if (bookFromDataBase != null) {
      Field[] fields = book.getClass().getDeclaredFields();
      AccessibleObject.setAccessible(fields, true);
      for (Field field : fields) {
        if (ReflectionUtils.getField(field, book) == null) {
          Object valueFromDb = ReflectionUtils.getField(field, bookFromDataBase);
          ReflectionUtils.setField(field, book, valueFromDb);
        }
      }
      return bookRepository.save(book);
    } else {
      throw new BookNotFoundException();
    }
  }

  public void deleteBook(int id) throws BookNotFoundException {
    if (bookRepository.findOne(id) == null) {
      throw new BookNotFoundException();
    } else {
      bookRepository.delete(id);
    }
  }
}

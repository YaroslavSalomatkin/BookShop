package com.bookshop.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "books")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "author")
  private String author;

  @Column(name = "description")
  private String description;

  @Column(name = "genre")
  @NotNull
  private String genre;

  @Column(name = "price")
  private BigDecimal price;

  public Book() {
  }

  public Book(int id, String bookName, String author, String description, String genre,
      BigDecimal price) {
    this.id = id;
    this.name = bookName;
    this.author = author;
    this.description = description;
    this.genre = genre;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBookName() {
    return name;
  }

  public void setBookName(String bookName) {
    this.name = bookName;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String  getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }
}

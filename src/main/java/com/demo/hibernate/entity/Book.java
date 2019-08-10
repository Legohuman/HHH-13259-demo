package com.demo.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String category;

  @OneToMany
  @JoinColumn(name = "origin_book", foreignKey = @ForeignKey(name = "fk_book_orig_book"))
  private Set<Book> relatedBooks = new HashSet<>();


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Set<Book> getRelatedBooks() {
    return relatedBooks;
  }

  public void setRelatedBooks(Set<Book> relatedBooks) {
    this.relatedBooks = relatedBooks;
  }
}

package com.demo.hibernate.output;

import com.demo.hibernate.dao.BookDao;
import com.demo.hibernate.entity.Book;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    BookDao b = new BookDao();
    b.getBooks();
  }
}

package com.demo.hibernate.dao;

import com.demo.hibernate.entity.Book;
import com.demo.hibernate.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BookDao {

  public List<Book> getBooks() {
    Session session = HibernateUtil.getSession();
    Query query = session.createQuery("select b1, b2 from Book b1, Book b2 where b2 member of b1.relatedBooks and b1.id in (?1) and b1.category in (?2) and b2.id not in (?1) and b2.category not in (?2)");
//    Query query = session.createQuery("select b1, b2 from Book b1, Book b2 where b2 member of b1.relatedBooks and b1.id in (?1)");
    query.setParameter(1, IntStream.rangeClosed(1, 3000).boxed().collect(Collectors.toList()));
    query.setParameter(2, IntStream.rangeClosed(1, 3000).mapToObj((i) -> "c" + i).collect(Collectors.toList()));
    List<Book> books = query.list();
    session.close();
    return books;
  }

  public List<Book> getBooksNative() {
    Session session = HibernateUtil.getSession();
    Query query = session.createQuery("select b1, b2 from Book b1, Book b2 where b2 member of b1.relatedBooks and b1.id in (?1) and b1.category in (?2) and b2.id not in (?1) and b2.category not in (?2)");
//    Query query = session.createSQLQuery("select * from book where id in values ((?1))");
    query.setParameter(1, IntStream.rangeClosed(1, 1).boxed().collect(Collectors.toList()));
    query.setParameter(2, IntStream.rangeClosed(1, 3000).mapToObj((i) -> "c" + i).collect(Collectors.toList()));
    List<Object[]> books = query.list();
    session.close();
    return new ArrayList<>();
  }
}

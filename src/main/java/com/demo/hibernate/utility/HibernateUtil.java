package com.demo.hibernate.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

  private static HibernateUtil instance = new HibernateUtil();
  private SessionFactory sessionFactory;

  private static HibernateUtil getInstance() {
    return instance;
  }

  private HibernateUtil() {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.xml");

    sessionFactory = configuration.buildSessionFactory();
  }

  public static Session getSession() {
    return getInstance().sessionFactory.openSession();
  }
}

package com.ttn;

import com.ttn.entity.Address;
import com.ttn.entity.Author;
import com.ttn.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        /*   Create*/

        Author author = new Author();
        author.setAuthorFirstName("HC ");
        author.setAuthorLasttName("Verma");
        // author.setId(1);

        /*READ*/
        /*SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Author author=session.get(Author.class,1);
        session.getTransaction().commit();
        session.close();
        System.out.println(author);*/

        /*Update*/
       /* SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Author author=session.get(Author.class,1);
        author.setAuthorName("RD Sharma");
        session.update(author);
        session.getTransaction().commit();
        session.close();
        System.out.println(author);
*/

        /*DELETE*/
/*
        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
       Author author=session.get(Author.class,1);
        session.delete(author);
        session.getTransaction().commit();
        session.close();
        System.out.println(author);
*/
        author.setDOB(new Date());
        Address address = new Address();
        address.setStreetNumber(101);
        address.setState("UP");
        address.setLocation("Noida");
        author.setAddress(address);

        List<String> sub = new ArrayList<>();
        sub.add("Drama");
        sub.add("Fiction");
        sub.add("Strory");
        author.setSubjects(sub);

        Book book = new Book();
        book.setBookName("Macbeth");
        author.setBook(book);

        Book book11 = new Book();
        book11.setBookName("Book11");
        Book book22 = new Book();
        book22.setBookName("Book2");
        author.getBooks().add(book11);
        author.getBooks().add(book22);

        book11.setAuthor(author);
        book22.setAuthor(author);


        Book book1 = new Book();
        book1.setBookName("BookName");
        author.getBooks3().add(book1);


        /*Question 3*/
        Author author2 = new Author();
        author2.setAuthorFirstName("KK");
        author2.setAuthorLasttName("Singh");
        // author2.setId(2);
        author2.setDOB(new Date());
        Address address2 = new Address();
        address2.setStreetNumber(102);
        address2.setState("Bihar");
        address2.setLocation("Patna");
        author2.setAddress(address2);

        List<String> sub2 = new ArrayList<>();
        sub2.add("Drama");
        sub2.add("Fiction");
        sub2.add("Strory");
        author2.setSubjects(sub2);

        Book book2 = new Book();
        book2.setBookName("Macbeth");
        author2.setBook(book2);

        Book book1111 = new Book();
        book1111.setBookName("Book1111");
        Book book2222 = new Book();
        book2222.setBookName("Book2222");
        author2.getBooks().add(book1111);
        author2.getBooks().add(book2222);

        book1111.setAuthor(author2);
        book2222.setAuthor(author2);


        Book book33 = new Book();
        book33.setBookName("BookName");
        author2.getBooks3().add(book33);


        Author author3 = new Author();
        author3.setAuthorFirstName("RS");
        author3.setAuthorLasttName("Agg");
        //  author3.setId(3);
        author3.setDOB(new Date());

        Address address3 = new Address();
        address3.setStreetNumber(103);
        address3.setState("Maharastra");
        address3.setLocation("Mumbai");
        author3.setAddress(address3);

        List<String> sub3 = new ArrayList<>();
        sub3.add("Drama");
        sub3.add("Fiction");
        sub3.add("Strory");
        author3.setSubjects(sub3);

        Book book3 = new Book();
        book3.setBookName("Macbeth");
        author3.setBook(book3);

        Book book111 = new Book();
        book111.setBookName("Book111");
        Book book222 = new Book();
        book222.setBookName("Book222");
        author3.getBooks().add(book111);
        author3.getBooks().add(book222);

        book111.setAuthor(author3);
        book222.setAuthor(author3);

        Book book44 = new Book();
        book44.setBookName("BookName");
        author3.getBooks3().add(book44);

        Author author4 = new Author();
        author4.setAuthorFirstName("Tom");
        author4.setAuthorLasttName("vig");
        //  author4.setId(4);
        author4.setDOB(new Date());

        Address address4 = new Address();
        address4.setStreetNumber(103);
        address4.setState("Karnataka");
        address4.setLocation("Bangalore");
        author4.setAddress(address4);

        List<String> sub4 = new ArrayList<>();
        sub4.add("Drama");
        sub4.add("Fiction");
        sub4.add("Strory");
        author4.setSubjects(sub4);


        Book book4 = new Book();
        book4.setBookName("Macbeth");
        author4.setBook(book4);

        Book book11111 = new Book();
        book11111.setBookName("Book11");
        Book book22222 = new Book();
        book22222.setBookName("Book2");
        author4.getBooks().add(book11111);
        author4.getBooks().add(book22222);

        book11111.setAuthor(author4);
        book22222.setAuthor(author4);

        Book book5 = new Book();
        book5.setBookName("BookName");
        author4.getBooks3().add(book5);

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(author);
        session.save(author2);
        session.save(author3);
        session.save(author4);
        session.save(book);
        session.save(book11);
        session.save(book111);

        session.save(book1111);

        session.save(book11111);

        session.save(book22);

        session.save(book222);

        session.save(book2222);

        session.save(book22222);

        session.getTransaction().commit();
        /*Question 4*/
        // sessionFactory.close();



    }
}

package com.ttn.entity;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "BookWriter")
public class Author {

    @Id
    @Column(name = "Identity")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;

    @Column(name = "FName")
    String AuthorFirstName;

    @Column(name = "LName")
    @Transient
    String AuthorLasttName;

    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    Date DOB;

    @Embedded
    Address address;

    @ElementCollection
    List<String> Subjects=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "Book_join_column")
    Book book;

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name="Author_ID")
            ,inverseJoinColumns = @JoinColumn(name = "Book_ID"))
    Collection<Book> books= new HashSet<>();

    @OneToMany/*(mappedBy = "Author")*/
    Collection<Book> books1= new HashSet<>();


    @ManyToMany
    List<Book> books2= new ArrayList<>();

    @OneToMany(cascade = CascadeType.PERSIST)
    Collection<Book> books3= new HashSet<>();

    public Collection<Book> getBooks3() {
        return books3;
    }

    public void setBooks3(Collection<Book> books3) {
        this.books3 = books3;
    }

    public List<Book> getBooks2() {
        return books2;
    }

    public void setBooks2(List<Book> books2) {
        this.books2 = books2;
    }

    public Collection<Book> getBooks1() {
        return books1;
    }

    public void setBooks1(Collection<Book> books1) {
        this.books1 = books1;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<String> getSubjects() {
        return Subjects;
    }

    public void setSubjects(List<String> subjects) {
        Subjects = subjects;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getAuthorFirstName() {
        return AuthorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        AuthorFirstName = authorFirstName;
    }

    public String getAuthorLasttName() {
        return AuthorLasttName;
    }

    public void setAuthorLasttName(String authorLasttName) {
        AuthorLasttName = authorLasttName;
    }



    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }



    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }




    @Override
    public String toString(){
        return  "Id="+Id+
                "Name="+AuthorFirstName+" "+AuthorLasttName;


    }
}

package com.ttn.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer BookId;
    String BookName;

    @ManyToOne
    Author author;

    @ManyToMany (mappedBy = "Books")
    List<Author> authorList= new ArrayList<>();

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getBookId() {
        return BookId;
    }

    public void setBookId(Integer bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }


}

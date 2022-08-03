package com.robin.gql.service;

import com.robin.gql.entity.Book;
import com.robin.gql.input.BookInput;

import java.util.List;

public interface IBookService {
    Book addBook(BookInput bookInput);

    Book queryBookById(String id);

    List<Book> queryBooks(String uid);
}

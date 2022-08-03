package com.robin.gql.service.impl;

import com.robin.gql.entity.Book;
import com.robin.gql.input.BookInput;
import com.robin.gql.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IBookServiceImpl implements IBookService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Book addBook(BookInput bookInput) {
        Book book = new Book();
        book.setName(bookInput.getName());
        book.setUid(bookInput.getUid());
        return mongoTemplate.save(book);
    }

    @Override
    public Book queryBookById(String id) {
        return mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), Book.class);
    }

    @Override
    public List<Book> queryBooks(String uid) {
        return mongoTemplate.find(Query.query(Criteria.where("uid").is(uid)),Book.class);
    }
}

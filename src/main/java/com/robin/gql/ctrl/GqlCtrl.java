package com.robin.gql.ctrl;

import com.robin.gql.entity.Book;
import com.robin.gql.entity.UserEntity;
import com.robin.gql.input.BookInput;
import com.robin.gql.input.UserInput;
import com.robin.gql.service.IBookService;
import com.robin.gql.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GqlCtrl {

    @Autowired
    private IUserService userService;

    @Autowired
    private IBookService bookService;

    @QueryMapping(name = "users")
    Iterable<UserEntity> users() {
        return this.userService.queryUser(null);
    }

    @MutationMapping("addUser")
    UserEntity createUser(@Argument UserInput user) {
        UserEntity userEntity = this.userService.addUser(user);
        return userEntity;
    }

    @MutationMapping("addBook")
    Book addBook( @Argument  BookInput book) {
        Book book1 = this.bookService.addBook(book);
        return book1;
    }

    @SchemaMapping(typeName = "UserEntity")
    List<Book> books(UserEntity user) {
        System.out.println(user.getId());
        return this.bookService.queryBooks(user.getId());
    }

}

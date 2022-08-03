package com.robin.gql.service;

import com.robin.gql.entity.UserEntity;
import com.robin.gql.input.UserInput;

import java.util.List;

public interface IUserService {

   UserEntity addUser(UserInput user);

    List<UserEntity> queryUser(UserEntity user);

}

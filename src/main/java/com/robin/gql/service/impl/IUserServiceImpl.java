package com.robin.gql.service.impl;

import com.robin.gql.entity.UserEntity;
import com.robin.gql.input.UserInput;
import com.robin.gql.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceImpl implements IUserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserEntity addUser(UserInput user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(user.getAge());
        userEntity.setName(user.getName());
        return mongoTemplate.save(userEntity);
    }

    @Override
    public List<UserEntity> queryUser(UserEntity user) {
        return mongoTemplate.findAll(UserEntity.class);
    }
}

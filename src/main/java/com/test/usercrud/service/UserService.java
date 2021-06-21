package com.test.usercrud.service;

import com.test.usercrud.domain.UserEntity;
import com.test.usercrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll(){
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(e -> users.add(e));
        return users;
    }

    public Optional<UserEntity> findById(int id) {
        Optional<UserEntity> member = userRepository.findById(id);
        return member;
    }

    public List<UserEntity> findByNameLike(String keyword){
        List<UserEntity> users = new ArrayList<>();
        userRepository.findByNameLike(keyword).forEach(e -> users.add(e));
        //.findAll().forEach(e -> users.add(e));
        return users;
    }



}

package com.test.usercrud.controller;

import com.test.usercrud.domain.UserEntity;
import com.test.usercrud.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    //기록
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    // 모든 회원 조회
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<UserEntity>> getAllmembers() {
        List<UserEntity> user = userService.findAll();
        return new ResponseEntity<List<UserEntity>>(user, HttpStatus.OK);
    }

    // 회원번호로 한명의 회원 조회
    @GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserEntity> getMember(@PathVariable("id") int id) {

        Optional<UserEntity> user = userService.findById(id);
        return new ResponseEntity<UserEntity>(user.get(), HttpStatus.OK);
    }







}

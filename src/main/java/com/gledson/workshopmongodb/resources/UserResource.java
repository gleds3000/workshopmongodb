package com.gledson.workshopmongodb.resources;


import com.gledson.workshopmongodb.domain.User;
import com.gledson.workshopmongodb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private  UserService serv;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        List<User> list = serv.findAll();
        return ResponseEntity.ok().body(list);
    }

    /*
    public ResponseEntity <List<User>> findAll(){

        User maria = new User("1", "Maria brown", "maria@teste.com");
        User alex = new User("2","Alex", "alex@teste.com");
        List<User> list = new ArrayList<>();

        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
  */
}

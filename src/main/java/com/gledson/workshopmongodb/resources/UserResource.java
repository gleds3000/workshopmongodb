package com.gledson.workshopmongodb.resources;


import com.gledson.workshopmongodb.domain.User;
import com.gledson.workshopmongodb.dto.UserDTO;
import com.gledson.workshopmongodb.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private  UserService serv;

    @RequestMapping(method= RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll(){
    //public ResponseEntity<List<User>> findAll(){
        List<User> list = serv.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping( value= "/{id}" , method= RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        User obj = serv.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping( method= RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
        User obj = serv.fromDTO(objDto);
        obj = serv.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
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

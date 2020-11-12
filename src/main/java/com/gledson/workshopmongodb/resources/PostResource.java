package com.gledson.workshopmongodb.resources;


import com.gledson.workshopmongodb.domain.Post;
import com.gledson.workshopmongodb.domain.User;
import com.gledson.workshopmongodb.dto.UserDTO;
import com.gledson.workshopmongodb.services.PostService;
import com.gledson.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostService serv;



    @RequestMapping( value= "/{id}" , method= RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = serv.findById(id);
        return ResponseEntity.ok().body(obj);
    }



}

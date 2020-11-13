package com.gledson.workshopmongodb.services;

import com.gledson.workshopmongodb.domain.Post;
import com.gledson.workshopmongodb.domain.User;
import com.gledson.workshopmongodb.dto.UserDTO;
import com.gledson.workshopmongodb.repository.PostRepository;
import com.gledson.workshopmongodb.repository.UserRepository;
import com.gledson.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;


    public List<Post> findAll(){
        return repo.findAll();

    }

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
//
//    public List<Post> findByTitle(String text){
//        return repo.findByTitleContainingIgnoreCase(text);
//    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

}

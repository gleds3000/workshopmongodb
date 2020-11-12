package com.gledson.workshopmongodb.config;

import com.gledson.workshopmongodb.domain.Post;
import com.gledson.workshopmongodb.domain.User;
import com.gledson.workshopmongodb.dto.AuthorDTO;
import com.gledson.workshopmongodb.dto.CommentDTO;
import com.gledson.workshopmongodb.repository.PostRepository;
import com.gledson.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User bere = new User(null, "Bere", "bere@gmail.com");
        User gledson = new User(null, "Gledson", "gledson@gmail.com");
        User luiz = new User(null, "luiz", "luiz@gmail.com");

        userRepository.saveAll(Arrays.asList(bere,gledson,luiz));

        Post post1 = new Post(null, sdf.parse("21/03/2020"), "Partiu viagem", "Vou viajar para Sao Paulo!", new AuthorDTO(gledson));
        Post post2 = new Post(null, sdf.parse("23/03/2020"), "Bom dia", "Vou ser feliz hoje!", new AuthorDTO(gledson));
        Post post3 = new Post(null, sdf.parse("11/11/2020"), "Boa Noite", "Mais um dia Praticando!", new AuthorDTO(gledson));


        CommentDTO comment1 = new CommentDTO("tenha uma otima viagem",sdf.parse("21/03/2020"), new AuthorDTO(luiz));
        CommentDTO comment2 = new CommentDTO("seja sempre feliz",sdf.parse("23/03/2020"), new AuthorDTO(bere));
        CommentDTO comment3 = new CommentDTO("Espero que seja um otimo dia",sdf.parse("23/03/2020"), new AuthorDTO(luiz));
        CommentDTO comment4 = new CommentDTO("A noite so esta começando",sdf.parse("11/11/2020"), new AuthorDTO(luiz));

        post1.getComment().addAll(Arrays.asList(comment1));
        post2.getComment().addAll(Arrays.asList(comment2,comment3));
        post3.getComment().addAll(Arrays.asList(comment4));

        postRepository.saveAll(Arrays.asList(post1,post2,post3));

        gledson.getPosts().addAll(Arrays.asList(post1,post2, post3));
        userRepository.save(gledson);

    }
}

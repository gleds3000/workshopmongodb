package com.gledson.workshopmongodb.config;

import com.gledson.workshopmongodb.domain.Post;
import com.gledson.workshopmongodb.domain.User;
import com.gledson.workshopmongodb.dto.AuthorDTO;
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

        postRepository.saveAll(Arrays.asList(post1,post2));
    }
}

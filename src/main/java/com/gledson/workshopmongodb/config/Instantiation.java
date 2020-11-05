package com.gledson.workshopmongodb.config;

import com.gledson.workshopmongodb.domain.User;
import com.gledson.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;



    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User bere = new User(null, "Bere", "bere@gmail.com");
        User gledson = new User(null, "Gledson", "gledson@gmail.com");
        User luiz = new User(null, "luiz", "luiz@gmail.com");


        userRepository.saveAll(Arrays.asList(bere,gledson,luiz));
    }
}

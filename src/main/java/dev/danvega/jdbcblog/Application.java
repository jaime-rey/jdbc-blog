package dev.danvega.jdbcblog;

import dev.danvega.jdbcblog.posts.Post;
import dev.danvega.jdbcblog.posts.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    static Logger log = org.apache.logging.log4j.LogManager.getLogger(Application.class);
    @Bean
    CommandLineRunner commandLineRunner(PostRepository repository) {
        return args -> {
            repository.save(new Post("1234",
                "Hello World",
                "hello-world",
                LocalDate.now(),
                10,
                "Spring Boot, Java",
                null));
            List<Post> posts = repository.findAll();
            for (Post post : posts) {
                log.info(post);

            }

            Optional<Post> bySlugIgnoreCase = repository.findBySlugIgnoreCase("hello-world");
            log.error(bySlugIgnoreCase);

        };
    }

}

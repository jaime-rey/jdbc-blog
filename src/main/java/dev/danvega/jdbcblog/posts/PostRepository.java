package dev.danvega.jdbcblog.posts;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface PostRepository extends ListCrudRepository<Post, String> {
        Optional<Post> findBySlugIgnoreCase(String slug);
}

package dev.danvega.jdbcblog.posts;

import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post, String> {
}

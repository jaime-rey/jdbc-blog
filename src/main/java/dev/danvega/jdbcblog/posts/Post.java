package dev.danvega.jdbcblog.posts;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;

public record Post(
        @Id
        String id,
        String title,
        String slug,
        LocalDate date,
        @Column("time_to_read")
        int timeToRead,
        String tags,
        @Version
        Integer version
) {
}

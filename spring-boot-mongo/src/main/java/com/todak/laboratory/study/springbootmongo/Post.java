package com.todak.laboratory.study.springbootmongo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document("post")
@Getter
public class Post {

    @Id
    private String id;

    private String title;

    private String content;

    private String author;

    private LocalDateTime writtenAt;

    private LocalDateTime updatedAt;

    public Post(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
        LocalDateTime now = LocalDateTime.now();
        this.writtenAt = now;
        this.updatedAt = now;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", writtenAt=" + writtenAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

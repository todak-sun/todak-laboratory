package com.todak.laboratory.study.springbootmongo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document("posts")
@Getter
public class Post {

    @Id
    private String id;

    private String title;

    private String content;

    private String author;

    private LocalDateTime writtenAt;

    private LocalDateTime updatedAt;

    private User writtenBy;

    public void changeContent(String content) {
        this.content = content;
    }

    public void writtenBy(User user){
        this.writtenBy = user;
    }

    public Post(String title, String content, String author, User writtenBy) {
        this.title = title;
        this.content = content;
        this.author = author;
        LocalDateTime now = LocalDateTime.now();
        this.writtenAt = now;
        this.updatedAt = now;
        this.writtenBy = writtenBy;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(content, post.content) && Objects.equals(author, post.author) && Objects.equals(writtenAt, post.writtenAt) && Objects.equals(updatedAt, post.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, author, writtenAt, updatedAt);
    }
}

package com.todak.laboratory.study.springbootmongo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@SpringBootTest
class PostRepositoryTest {


    @Autowired
    PostRepository postRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    public void saveTest() {
        Post save = postRepository.save(new Post("title", "content", "author", null));
        log.info("save : {}", save);
        postRepository.deleteAll();
    }

    @Test
    public void pagingTest() {
        List<Post> posts = IntStream.rangeClosed(1, 100)
                .mapToObj((i) -> new Post("title" + i, "content" + i, "author" + i, null))
                .collect(Collectors.toList());

        postRepository.saveAll(posts);

        Page<Post> pagedResult = postRepository.findAll(PageRequest.of(0, 10));
        List<Post> content = pagedResult.getContent();

        content.forEach(post -> {
            log.info("post : {}", post);
        });

        assertEquals(content.size(), 10);
        postRepository.deleteAll();
    }

    @Test
    public void query() {

//        User savedUser = mongoTemplate.save(new User("todak-sun", "email@email.com"));
        mongoTemplate.save(new Post("title", "content", "author", null));

    }

    @Test
    public void findQuery() {



        List<Post> posts = mongoTemplate.find(Query.query(Criteria.where("writtenBy.name")
                .is("todak-sun")
        ), Post.class);

        log.info("posts : {}", posts);
    }

}
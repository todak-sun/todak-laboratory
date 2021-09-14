package com.todak.laboratory.study.springbootmongo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PostCustomRepository {

    private final MongoTemplate mongoTemplate;

    public void test() {
        mongoTemplate.findOne(Query.query(
                Criteria.where("content").is("hello")),
                Post.class
        );
    }


}

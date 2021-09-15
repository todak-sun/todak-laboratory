package com.todak.laboratory.study.springbootmongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PostRepository extends MongoRepository<Post, String> {



}

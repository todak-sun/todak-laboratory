package com.todak.laboratory.study.springbootmongo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    public void savePosts() {
        List<Post> posts = IntStream.range(0, 100)
                .mapToObj(i -> new Post("title" + i, "content" + i, "author" + i, null))
                .collect(Collectors.toList());
        postRepository.saveAll(posts);
    }

}

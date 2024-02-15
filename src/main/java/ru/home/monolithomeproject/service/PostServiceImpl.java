package ru.home.monolithomeproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.home.monolithomeproject.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostServiceImpl {
    private final PostRepository postRepository;


}

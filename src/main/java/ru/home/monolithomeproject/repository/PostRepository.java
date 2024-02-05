package ru.home.monolithomeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.home.monolithomeproject.entity.Post;

public interface PostRepository extends JpaRepository<Post, String> {
}

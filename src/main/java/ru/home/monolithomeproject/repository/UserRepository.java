package ru.home.monolithomeproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.home.monolithomeproject.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
}

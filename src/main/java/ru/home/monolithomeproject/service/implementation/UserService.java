package ru.home.monolithomeproject.service.implementation;

import ru.home.monolithomeproject.entity.User;

public interface UserService {
    User createUser(User user, byte[] avatar);
}

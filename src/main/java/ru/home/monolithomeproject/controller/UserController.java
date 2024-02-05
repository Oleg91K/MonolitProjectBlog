package ru.home.monolithomeproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.home.monolithomeproject.entity.User;
import ru.home.monolithomeproject.service.implementation.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/create",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<User> createUser(@RequestParam("name") String name,
                                     @RequestParam("surName") String surName,
                                     @RequestPart("avatarFile") MultipartFile avatarFile) {
        User user = new User();
        user.setName(name);
        user.setSurName(surName);

        try {
            if (avatarFile != null && !avatarFile.isEmpty()) {
                byte[] avatarBytes = avatarFile.getBytes();
                user = userService.createUser(user, avatarBytes);
            } else {
                user = userService.createUser(user, null);
            }
        } catch (Exception e) {
            System.out.println("Сохранение пользователя не удалось");
        }

        return ResponseEntity.ok(userService.createUser(user, user.getAvatar()));
    }
}


package ru.home.monolithomeproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.home.monolithomeproject.entity.User;
import ru.home.monolithomeproject.repository.UserRepository;
import ru.home.monolithomeproject.service.implementation.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user, byte[] avatar) {
        try {
            if (avatar != null && avatar.length > 0) {
                String fileName = "avatar_" + UUID.randomUUID()+ ".jpg";
                String uploadDir = "avatars";

                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Path filePath = uploadPath.resolve(fileName);
                Files.write(filePath, avatar);
                user.setFileName(fileName);
                user.setAvatar(avatar);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении файла аватара: " + e.getMessage());
        }

        user.setName(user.getName());
        user.setSurName(user.getSurName());

        return userRepository.save(user);
    }
}

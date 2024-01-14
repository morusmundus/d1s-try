package com.example.server.service;

import com.example.server.dto.UserChangesDto;
import com.example.server.entity.enm.Role;
import com.example.server.entity.User;
import com.example.server.dto.Message;
import com.example.server.repositories.Repository;
import com.example.server.repositories.UserRepository;
import com.example.server.service.messages.MessageService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService extends AbstractService<User> {

    private final MessageService messageService;

    public UserService(Repository<User> repository, MessageService messageService) {
        super(repository);
        this.messageService = messageService;
    }

    public Optional<User> findByEmail(String email) {
        return ((UserRepository) repository).findByEmail(email);
    }

    public void register(String email, String encodedPassword) {
        Optional<User> byEmail = findByEmail(email);
        if (byEmail.isPresent()) {
            throw new DuplicateKeyException("Duplicated email");
        }
        User user = User.builder()
                .email(email)
                .password(encodedPassword)
                .role(Role.USER)
                .build();
        repository.save(user);
    }

    public void recoverPassword(String email) {
        Optional<User> byEmail = findByEmail(email);
        if (byEmail.isEmpty()) {
            throw new NoSuchElementException();
        }

        User user = byEmail.get();
        String newPassword = "111";
        user.setPassword("$2a$12$QpbP8G.IuWjQF8q09INLHejRnX2NZjSnq7uAjIBWCjCnMpKQGUo12");
        repository.save(user);

        Message message = Message.builder()
                .receiver(email)
                .subject("Восстановление пароля")
                .message("Ваш новый пароль для входа: " + newPassword)
                .build();
        messageService.sendMail(message);
    }


    public void update(UserChangesDto dto) {
        System.out.println(dto);
        repository.findById(dto.getId()).ifPresent(u -> {
            u.setRole(Role.valueOf(dto.getRole()));
            u.setBlocked(dto.isBlocked());

            repository.save(u);
        });
    }
}
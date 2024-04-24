package org.rio.services;

import org.rio.entities.User;
import org.rio.interfaces.IUserService;
import org.rio.interfaces.repositories.IUserRepository;
import org.rio.records.users.CreateUserRequest;
import org.rio.records.users.UpdateUserRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User(request.id(), request.name());
        return userRepository.createUser(user);
    }

    @Override
    public User updateUser(String userId, UpdateUserRequest request) {
        // TODO: add update user logic
        return null;
    }

    @Override
    public User getUser(String id) {
        return userRepository.getUser(id);
    }
}

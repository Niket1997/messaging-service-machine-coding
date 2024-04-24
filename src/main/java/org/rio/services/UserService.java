package org.rio.services;

import org.rio.entities.User;
import org.rio.excetions.users.UserExistsException;
import org.rio.excetions.users.UserNotFoundException;
import org.rio.interfaces.IUserService;
import org.rio.records.users.CreateUserRequest;
import org.rio.records.users.UpdateUserRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserService implements IUserService {
    HashMap<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    @Override
    public User createUser(CreateUserRequest request) {
        if (users.containsKey(request.id())) throw new UserExistsException("username already exists");
        User user = new User(request.id(), request.name());
        users.put(request.id(), user);
        return user;
    }

    @Override
    public User updateUser(String userId, UpdateUserRequest request) {
        // TODO: add update user logic
        return null;
    }

    @Override
    public User getUser(String id) {
        if (!users.containsKey(id)) throw new UserNotFoundException("username not found");
        return users.get(id);
    }
}

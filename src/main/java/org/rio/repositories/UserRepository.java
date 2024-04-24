package org.rio.repositories;

import org.rio.entities.User;
import org.rio.excetions.users.UserExistsException;
import org.rio.excetions.users.UserNotFoundException;
import org.rio.interfaces.repositories.IUserRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class UserRepository implements IUserRepository {
    HashMap<String, User> users;

    public UserRepository() {
        users = new HashMap<>();
    }

    @Override
    public User createUser(User user) {
        if (users.containsKey(user.getId())) throw new UserExistsException("user already exists");
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public User getUser(String userId) {
        if (!users.containsKey(userId)) throw new UserNotFoundException("user not found");
        return users.get(userId);
    }

    @Override
    public User updateUser(User user) {
        if (!users.containsKey(user.getId())) throw new UserNotFoundException("user not found");
        users.put(user.getId(), user);
        return user;
    }
}

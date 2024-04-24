package org.rio.interfaces.repositories;

import org.rio.entities.User;

public interface IUserRepository {
    User createUser(User user);

    User getUser(String userId);

    User updateUser(User user);
}

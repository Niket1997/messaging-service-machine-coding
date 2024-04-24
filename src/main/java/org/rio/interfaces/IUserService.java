package org.rio.interfaces;

import org.rio.entities.User;
import org.rio.records.users.CreateUserRequest;
import org.rio.records.users.UpdateUserRequest;

public interface IUserService {
    User createUser(CreateUserRequest request);

    User updateUser(String userId, UpdateUserRequest request);

    User getUser(String id);
}

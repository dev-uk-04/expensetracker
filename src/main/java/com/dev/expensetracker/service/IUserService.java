package com.dev.expensetracker.service;

import com.dev.expensetracker.entity.User;
import com.dev.expensetracker.entity.UserModel;

public interface IUserService {

    User createUser(UserModel user);

    User readUser(Long id);

    User updateUser(UserModel user, Long id);

    void deleteUser(Long id);
}

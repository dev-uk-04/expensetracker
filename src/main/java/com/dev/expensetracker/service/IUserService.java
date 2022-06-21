package com.dev.expensetracker.service;

import com.dev.expensetracker.entity.User;
import com.dev.expensetracker.entity.UserModel;

public interface IUserService {

    User createUser(UserModel user);

    User readUser();

    User updateUser(UserModel user);

    void deleteUser();

    User getLoggedInUser();
}

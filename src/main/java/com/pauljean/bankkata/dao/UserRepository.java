package com.pauljean.bankkata.dao;

import com.pauljean.bankkata.entity.User;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserRepository {

    private static Set<User> userList = new HashSet<User>();

    private static UserRepository userRepository;

    private UserRepository() {
    }

    public static UserRepository getInstance() {

        if (Objects.isNull(userRepository)) {
            userRepository = new UserRepository();
            return userRepository;
        }

        return userRepository;
    }

    public void create(User user) {

        userList.add(user);
    }

    public boolean remove(long userId) {

        return userList.removeIf(user -> userId == user.getUserId());

    }

    public User findbyUserId(long userId) {
        return userList.stream().filter(user -> userId == user.getUserId()).findFirst().orElseThrow(() -> new RuntimeException("user not found"));
    }

    public boolean checkUserExist() {

        return userList.isEmpty();
    }
}

package com.myProject.cryptoCurrencyWatcher.service;

import com.myProject.cryptoCurrencyWatcher.repository.entity.User;

import java.util.List;

public interface UserService {

    Iterable<User> findAll();

    List<User> findBySymbol(String symbol);

    User createUser (User user);
}

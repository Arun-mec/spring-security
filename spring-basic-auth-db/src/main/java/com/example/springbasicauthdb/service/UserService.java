package com.example.springbasicauthdb.service;


import com.example.springbasicauthdb.enitty.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User user);

}

package com.example.springjwtauth.service;

import com.example.springjwtauth.entity.State;

import java.util.List;
import java.util.UUID;

public interface StateService {

    List<State> getAllStates();

    State createState(State state);

    void deleteStates(UUID id);
}

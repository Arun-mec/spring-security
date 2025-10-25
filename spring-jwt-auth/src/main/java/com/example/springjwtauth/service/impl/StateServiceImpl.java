package com.example.springjwtauth.service.impl;

import com.example.springjwtauth.entity.State;
import com.example.springjwtauth.repository.StateRepository;
import com.example.springjwtauth.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    StateRepository stateRepository;

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    @Override
    public State createState(State state) {
        return stateRepository.save(state);
    }

    @Override
    public void deleteStates(UUID id) {
        stateRepository.deleteById(id);
    }
}

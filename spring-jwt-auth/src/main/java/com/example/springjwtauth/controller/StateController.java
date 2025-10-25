package com.example.springjwtauth.controller;

import com.example.springjwtauth.entity.State;
import com.example.springjwtauth.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/state")
public class StateController {

    @Autowired
    StateService stateService;

    @GetMapping
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @PostMapping
    public State createState(@RequestBody State state) {
        return stateService.createState(state);
    }

    @DeleteMapping("/{id}")
    public void deleteState(@PathVariable UUID id) {
        stateService.deleteStates(id);
    }
}

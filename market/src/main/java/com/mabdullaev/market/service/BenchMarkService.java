package com.mabdullaev.market.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@AllArgsConstructor
public class BenchMarkService {
    private HashMap<String, Long> controllers;

    public void logElapsed(String methodName, Long millis) {

        if (controllers.containsKey(methodName)) {
            controllers.put(methodName, millis + controllers.get(methodName));
        } else {
            controllers.put(methodName, millis);
        }

    }

    public ResponseEntity<?> stats(){
        return ResponseEntity.ok(controllers);
    }
}

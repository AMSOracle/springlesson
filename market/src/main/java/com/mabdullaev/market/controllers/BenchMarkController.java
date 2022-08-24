package com.mabdullaev.market.controllers;

import com.mabdullaev.market.service.BenchMarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/benchmark")
@RequiredArgsConstructor
public class BenchMarkController {

    private final BenchMarkService benchMarkService;
    @GetMapping
    public ResponseEntity<?> stats(){
        return benchMarkService.stats();
    }
}

package com.mabdullaev.lesson.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {
    private String token;

    public AuthResponse(String token){
        this.token = token;
    }
}

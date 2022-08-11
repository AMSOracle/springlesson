package com.mabdullaev.lesson.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthRequest {
    private String username;
    private String password;
}

package com.cafe.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private long user_id;
    private String name;
    private String email;
    private String role;
    private String password;

}

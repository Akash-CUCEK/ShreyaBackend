package com.shreya.dto.request;

import com.shreya.entity.Role;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterRequestDTO {
    private String userName;
    private String password;
    private Role role;
    private String fullName;
}

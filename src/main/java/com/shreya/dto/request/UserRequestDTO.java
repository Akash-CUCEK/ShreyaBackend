package com.shreya.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    private String userName;
    private String password;
}

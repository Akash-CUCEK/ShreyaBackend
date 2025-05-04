package com.shreya.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "User Name cannot be null")
    @Size(min = 3, max = 8,message = "user Name can have minimum 3 and maximum 8 in length")
    @Column(nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false, unique = true)
    private String fullName;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private boolean emailVerified;
}

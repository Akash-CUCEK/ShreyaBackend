package com.shreya.appointment_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "appointment")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long serviceId;

    private LocalDate appointmentDate;

    private LocalTime appointmentTime;

    private String status;

    @Version
    private Long version;

}

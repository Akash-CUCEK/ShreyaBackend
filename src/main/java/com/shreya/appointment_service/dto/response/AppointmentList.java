package com.shreya.appointment_service.dto.response;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentList {
    private Long serviceId;
    private LocalDate appointmentDate;
}

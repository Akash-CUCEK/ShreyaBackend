package com.shreya.appointment_service.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAppointmentRequestDTO {
    private Long userId;
}

package com.shreya.appointment_service.dto.request;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancelAppointmentRequestDTO {
    private Long id;
}

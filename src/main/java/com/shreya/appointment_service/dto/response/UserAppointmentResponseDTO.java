package com.shreya.appointment_service.dto.response;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAppointmentResponseDTO {
    List<AppointmentList> appointmentLists;
}

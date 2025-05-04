package com.shreya.appointment_service.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateRequestDTO {
    private Long userId;
    private Long serviceId;
    private LocalDate appointmentDate;
    @JsonFormat(pattern = "HH:mm")
    @Schema(type = "string", example = "12:10")
    private LocalTime appointmentTime;

}

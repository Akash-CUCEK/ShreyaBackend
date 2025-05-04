package com.shreya.appointment_service.service;

import com.shreya.appointment_service.dto.request.CancelAppointmentRequestDTO;
import com.shreya.appointment_service.dto.request.CreateRequestDTO;
import com.shreya.appointment_service.dto.request.RescheduleAppointmentRequestDTO;
import com.shreya.appointment_service.dto.request.UserAppointmentRequestDTO;
import com.shreya.appointment_service.dto.response.CancelAppointmentResponseDTO;
import com.shreya.appointment_service.dto.response.CreateResponseDTO;
import com.shreya.appointment_service.dto.response.RescheduleAppointmentResponseDTO;
import com.shreya.appointment_service.dto.response.UserAppointmentResponseDTO;

public interface AppointmentService {
    CreateResponseDTO createAppointment(String requestId, CreateRequestDTO createRequestDTO);

    UserAppointmentResponseDTO fetchAppointmentListByUserId(String requestId, UserAppointmentRequestDTO userAppointmentRequestDTO);

    CancelAppointmentResponseDTO cancelAppointment(String requestId, CancelAppointmentRequestDTO cancelAppointmentRequestDTO);

    RescheduleAppointmentResponseDTO rescheduleAppointment(String requestId, RescheduleAppointmentRequestDTO rescheduleAppointmentRequestDTO);
}

package com.shreya.appointment_service.mapper;

import com.shreya.appointment_service.dao.AppointmentDAO;
import com.shreya.appointment_service.dto.request.CreateRequestDTO;
import com.shreya.appointment_service.dto.request.RescheduleAppointmentRequestDTO;
import com.shreya.appointment_service.entity.Appointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentMapper.class);
    private final AppointmentDAO appointmentDAO;

    @Autowired
    public AppointmentMapper(AppointmentDAO appointmentDAO) {
        this.appointmentDAO = appointmentDAO;
    }

    public Appointment saveAppointment(CreateRequestDTO createRequestDTO, String requestId) {
        logger.debug("calling map to create appointment for requestId: {}"
                ,requestId);

        // Create and save the appointment
        return Appointment.builder()
                .userId(createRequestDTO.getUserId())
                .serviceId(createRequestDTO.getServiceId())
                .appointmentDate(createRequestDTO.getAppointmentDate())
                .appointmentTime(createRequestDTO.getAppointmentTime())
                .status("PENDING")
                .build();
    }

    public Appointment updateAppointment(String requestId, RescheduleAppointmentRequestDTO rescheduleAppointmentRequestDTO){
        logger.info("calling map to update appointment for requestId: {}",requestId);

        var appointment = appointmentDAO.findById(rescheduleAppointmentRequestDTO.getId());
        appointment.setAppointmentDate(rescheduleAppointmentRequestDTO.getAppointmentDate());
        appointment.setAppointmentTime(rescheduleAppointmentRequestDTO.getAppointmentTime());
        appointment.setStatus("PENDING");
        return appointment;
    }

    public void cancelAppointment(Appointment response){
         response.setStatus("CANCELLED");
    }
}

package com.shreya.appointment_service.dao;

import com.shreya.appointment_service.dto.response.AppointmentList;
import com.shreya.appointment_service.dto.response.UserAppointmentResponseDTO;
import com.shreya.appointment_service.entity.Appointment;
import com.shreya.appointment_service.repository.AppointmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.shreya.common.exception.SRYException;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentDAO {
    private final AppointmentRepository appointmentRepository;
    private static final Logger logger = LoggerFactory.getLogger(AppointmentDAO.class);

    public AppointmentDAO(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    // Method to check appointment availability
    public void checkAppointmentAvailability(String requestId, LocalDate appointmentDate, LocalTime appointmentTime) {
        var existingAppointment = appointmentRepository.findByAppointmentDateAndAppointmentTimeAndStatusIn(
                appointmentDate,
                appointmentTime,
                List.of("PENDING", "BOOKED")
        );

        if (existingAppointment.isPresent()) {
//            throw new com.shreya.common.exception.SRYException()
//            logger.error("Appointment slot already booked at {} {}", appointmentDate, appointmentTime);
//            throw new SRYException(
//                    HttpStatus.CONFLICT,
//                    ErrorCodeConstants.ERROR_CODE_APPOINTMENT_ALREADY_BOOKED,
//                    "Appointment slot already booked",
//                    String.format("Appointment already exists at %s %s", appointmentDate, appointmentTime)
//            );
        }
    }

    // Method to save an appointment
    public void save(Appointment appointmentDetails) {
        try {
            logger.info("Saving appointment: {}", appointmentDetails);
            appointmentRepository.save(appointmentDetails);
        } catch (Exception e) {
            logger.error("Error saving appointment: {}", e.getMessage());
//            throw new com.shreya.common.exception.SRYException(
//                    HttpStatus.INTERNAL_SERVER_ERROR,
//                    ErrorCodeConstants.ERROR_CODE_GENERIC_ERROR,
//                    "Something went wrong while saving the appointment",
//                    "Please try again later"
//            );
        }
    }

    // Method to find the list of appointments by user ID
    public UserAppointmentResponseDTO findList(String requestId, Long userId) {
        // Fetch appointments from the repository
        var appointments = appointmentRepository.findByUserId(userId);

        // If no appointments found, throw an exception
        if (appointments.isEmpty()) {
            logger.warn("No bookings found for user: {}", userId);
//            throw new SRYException(
//                    HttpStatus.NOT_FOUND,
//                    ErrorCodeConstants.ERROR_CODE_NO_BOOKING,
//                    "There is no booking yet for this user",
//                    "Please check the user ID or create a new booking"
//            );
        }

        // Map each Appointment entity to AppointmentList DTO
        var appointmentLists = appointments.stream()
                .map(appointment -> new AppointmentList(
                        appointment.getServiceId(),
                        appointment.getAppointmentDate()
                ))
                .collect(Collectors.toList());

        // Return the response DTO with the mapped appointment list
        return UserAppointmentResponseDTO.builder()
                .appointmentLists(appointmentLists)
                .build();
    }

    // Method to find appointment by ID
    public Appointment findById(Long id) {
        var response = appointmentRepository.findById(id);
//                .orElseThrow(() -> new SRYException(
//                        HttpStatus.NOT_FOUND,
//                        ErrorCodeConstants.ERROR_CODE_APPOINTMENT_NOT_FOUND,
//                        "There is no appointment with this id",
//                        "Please check the appointment ID and try again"
//                ));

//        if (response.getStatus().equalsIgnoreCase("CANCELLED")) {
//            logger.warn("Appointment with id {} is already cancelled", id);
//            throw new SRYException(
//                    HttpStatus.CONFLICT,
//                    ErrorCodeConstants.ERROR_CODE_APPOINTMENT_CANCELLED,
//                    "Already cancelled, please wait for confirmation",
//                    "The appointment has already been cancelled"
//            );
//        }
        return null;
    }
}

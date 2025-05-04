package com.shreya.appointment_service.controller;

import com.shreya.appointment_service.dto.request.CancelAppointmentRequestDTO;
import com.shreya.appointment_service.dto.request.CreateRequestDTO;
import com.shreya.appointment_service.dto.request.RescheduleAppointmentRequestDTO;
import com.shreya.appointment_service.dto.request.UserAppointmentRequestDTO;
import com.shreya.appointment_service.dto.response.CancelAppointmentResponseDTO;
import com.shreya.appointment_service.dto.response.CreateResponseDTO;
import com.shreya.appointment_service.dto.response.RescheduleAppointmentResponseDTO;
import com.shreya.appointment_service.dto.response.UserAppointmentResponseDTO;
import com.shreya.appointment_service.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/appointment")
public class AppointmentController {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentController.class);
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/create")
    public ResponseEntity<CreateResponseDTO> createAppointment(
            @RequestParam String requestId,
            @RequestBody CreateRequestDTO createRequestDTO
    ){
        logger.info("Received request for creating an appointment for requestId {}",requestId);
        var response = appointmentService.createAppointment(requestId, createRequestDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/appointmentList")
    public ResponseEntity<UserAppointmentResponseDTO> fetchAppointmentListByUserId(@RequestParam String requestId
            , @RequestBody UserAppointmentRequestDTO userAppointmentRequestDTO
    ){
        logger.info("Received request for fetching appointment List of userId: {}",userAppointmentRequestDTO.getUserId());
        var response = appointmentService.fetchAppointmentListByUserId(requestId,userAppointmentRequestDTO);
        return new ResponseEntity<>(response,HttpStatus.FOUND);
    }
    @PostMapping("/cancelAppointment")
    public ResponseEntity<CancelAppointmentResponseDTO> cancelAppointment(
            @RequestParam String requestId,
            @RequestBody CancelAppointmentRequestDTO cancelAppointmentRequestDTO
    ){
        logger.info("Received request for cancel appointment for requestId: {}",requestId);
        var response = appointmentService.cancelAppointment(requestId,cancelAppointmentRequestDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @PostMapping("/rescheduleAppointment")
    public ResponseEntity<RescheduleAppointmentResponseDTO> rescheduleAppointment(
            @RequestParam String requestId,
            @RequestBody RescheduleAppointmentRequestDTO rescheduleAppointmentRequestDTO
            )
    {
        logger.info("Received request for rescheduling appointment for requestId: {}",requestId);
        var response = appointmentService.rescheduleAppointment(requestId,rescheduleAppointmentRequestDTO);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

}

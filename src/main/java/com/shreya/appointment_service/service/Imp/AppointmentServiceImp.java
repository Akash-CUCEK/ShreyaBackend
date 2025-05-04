package com.shreya.appointment_service.service.Imp;

import com.shreya.appointment_service.controller.AppointmentController;
import com.shreya.appointment_service.dao.AppointmentDAO;
import com.shreya.appointment_service.dto.request.CancelAppointmentRequestDTO;
import com.shreya.appointment_service.dto.request.CreateRequestDTO;
import com.shreya.appointment_service.dto.request.RescheduleAppointmentRequestDTO;
import com.shreya.appointment_service.dto.request.UserAppointmentRequestDTO;
import com.shreya.appointment_service.dto.response.CancelAppointmentResponseDTO;
import com.shreya.appointment_service.dto.response.CreateResponseDTO;
import com.shreya.appointment_service.dto.response.RescheduleAppointmentResponseDTO;
import com.shreya.appointment_service.dto.response.UserAppointmentResponseDTO;
import com.shreya.appointment_service.mapper.AppointmentMapper;
import com.shreya.appointment_service.service.AppointmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImp implements AppointmentService {
    private static final Logger logger = LoggerFactory.getLogger(AppointmentServiceImp.class);

    private final AppointmentDAO appointmentDAO;
    private final AppointmentMapper appointmentMapper;


    public AppointmentServiceImp(AppointmentDAO appointmentDAO, AppointmentMapper appointmentMapper) {
        this.appointmentDAO = appointmentDAO;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public CreateResponseDTO createAppointment(String requestId, CreateRequestDTO createRequestDTO) {
        appointmentDAO.checkAppointmentAvailability(requestId, createRequestDTO.getAppointmentDate(),createRequestDTO.getAppointmentTime());
        var appointmentDetails = appointmentMapper.saveAppointment(createRequestDTO,requestId);
        appointmentDAO.save(appointmentDetails);
        return CreateResponseDTO.builder()
                .message("Appointment Created, wait for conformation!!!")
                .build();
    }

    @Override
    public UserAppointmentResponseDTO fetchAppointmentListByUserId(String requestId, UserAppointmentRequestDTO userAppointmentRequestDTO) {
        return appointmentDAO.findList(requestId,userAppointmentRequestDTO.getUserId());
    }

    @Override
    public CancelAppointmentResponseDTO cancelAppointment(String requestId, CancelAppointmentRequestDTO cancelAppointmentRequestDTO) {
        var response = appointmentDAO.findById(cancelAppointmentRequestDTO.getId());
        appointmentMapper.cancelAppointment(response);
        appointmentDAO.save(response);
        return CancelAppointmentResponseDTO.builder()
                .message("Cancelled, wait for approval")
                .build();
    }

    @Override
    public RescheduleAppointmentResponseDTO rescheduleAppointment(String requestId, RescheduleAppointmentRequestDTO rescheduleAppointmentRequestDTO) {
        appointmentDAO.checkAppointmentAvailability(requestId,rescheduleAppointmentRequestDTO.getAppointmentDate(),rescheduleAppointmentRequestDTO.getAppointmentTime());
        var response = appointmentMapper.updateAppointment(requestId,rescheduleAppointmentRequestDTO);
        appointmentDAO.save(response);
        return RescheduleAppointmentResponseDTO.builder()
                .message("Reshudled successfully. Wait for conformation!!!")
                .build();

    }
}

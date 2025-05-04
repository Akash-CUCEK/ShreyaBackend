package com.shreya.appointment_service.repository;

import com.shreya.appointment_service.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    Optional<Appointment> findByAppointmentDateAndAppointmentTimeAndStatusIn(LocalDate appointmentDate, LocalTime appointmentTime, List<String> statuses);

    List<Appointment> findByUserId(Long userId);
}

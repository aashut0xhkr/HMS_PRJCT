package com.Major.Project.Appointment.Controller;

import com.Major.Project.Appointment.Entity.Appointment;
import com.Major.Project.Appointment.Service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/HMS/Appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAppointments();
    }
    @GetMapping("/{id}")
    public Appointment getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }
    @PostMapping
    public Appointment createAppointment(@RequestBody Appointment appointment){
        return appointmentService.CreateAppointment(appointment);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteAppointment(@PathVariable Long id){
        appointmentService.DeleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long id,@RequestBody Appointment appointment ){
        Appointment updated = appointmentService.updateAppointment(id, appointment);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @GetMapping("/doctor/{doctorId}")
    public List<Appointment> getByDoctor(@PathVariable Long doctorId) {
        return appointmentService.findByDoctorId(doctorId);
    }

    @GetMapping("/patient/{patientId}")
    public List<Appointment> getByPatient(@PathVariable Long patientId) {
        return appointmentService.findByPatientId(patientId);
    }

}

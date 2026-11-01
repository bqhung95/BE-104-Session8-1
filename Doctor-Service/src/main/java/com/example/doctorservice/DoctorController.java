package com.example.doctorservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @GetMapping("/api/doctors/check-schedule")
    public String checkSchedule(@RequestParam String doctorId) {
        // Giả lập logic kiểm tra lịch trực
        return "Bác sĩ " + doctorId + " có lịch trực vào ngày mai.";
    }
}
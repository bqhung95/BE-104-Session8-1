package com.example.appointment;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    // Tên "doctorServiceCB" phải khớp với cấu hình trong application.properties
    @CircuitBreaker(name = "doctorServiceCB", fallbackMethod = "fallbackAddAppointment")
    public String addAppointment(String appointmentData) {
        // Logic gọi sang Doctor-Service (ví dụ: RestTemplate hoặc Feign)
        // Nếu Doctor-Service sập, dòng này sẽ ném Exception
        return callDoctorServiceToCheckSchedule(appointmentData);
    }

    // Phương thức Fallback: Phải cùng kiểu trả về và có thêm tham số Exception ở cuối
    public String fallbackAddAppointment(String appointmentData, Exception e) {
        // Trả về thông báo lỗi ngay lập tức thay vì chờ timeout
        return "Hệ thống đang bảo trì (Doctor-Service không phản hồi). Vui lòng thử lại sau!";
    }

    private String callDoctorServiceToCheckSchedule(String data) {
        // Giả lập gọi HTTP đến Doctor-Service port 8082
        // ...
        return "OK";
    }
}

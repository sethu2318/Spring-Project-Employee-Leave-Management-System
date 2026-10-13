package com.example.leave.controller;

import com.example.leave.model.LeaveRequest;
import com.example.leave.service.LeaveService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/leaves")
public class LeaveController {

    private final LeaveService leaveService;

    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    // POST /api/leaves  -> apply for leave
    @PostMapping
    public ResponseEntity<LeaveRequest> applyLeave(@Valid @RequestBody LeaveRequest leave) {
        LeaveRequest saved = leaveService.applyLeave(leave);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    // GET /api/leaves  -> all leave applications
    @GetMapping
    public List<LeaveRequest> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    // GET /api/leaves/1  -> one leave application
    @GetMapping("/{id}")
    public LeaveRequest getLeave(@PathVariable Long id) {
        return leaveService.getLeaveById(id);
    }

    // GET /api/leaves/type/Sick  -> leaves of one type
    @GetMapping("/type/{leaveType}")
    public List<LeaveRequest> getByType(@PathVariable String leaveType) {
        return leaveService.getLeavesByType(leaveType);
    }

    // PUT /api/leaves/1  -> update
    @PutMapping("/{id}")
    public LeaveRequest updateLeave(@PathVariable Long id, @Valid @RequestBody LeaveRequest leave) {
        return leaveService.updateLeave(id, leave);
    }

    // DELETE /api/leaves/1  -> cancel
    @DeleteMapping("/{id}")
    public Map<String, String> cancelLeave(@PathVariable Long id) {
        leaveService.cancelLeave(id);
        return Map.of("message", "Leave cancelled successfully");
    }
}

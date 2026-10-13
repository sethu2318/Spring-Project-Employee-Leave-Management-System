package com.example.leave.service;

import com.example.leave.exception.LeaveNotFoundException;
import com.example.leave.model.LeaveRequest;
import com.example.leave.repository.LeaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    // Apply for leave
    public LeaveRequest applyLeave(LeaveRequest leave) {
        return leaveRepository.save(leave);
    }

    // Get all leave applications
    public List<LeaveRequest> getAllLeaves() {
        return leaveRepository.findAll();
    }

    // Get one leave application by id
    public LeaveRequest getLeaveById(Long id) {
        return leaveRepository.findById(id)
                .orElseThrow(() -> new LeaveNotFoundException("Leave not found with id " + id));
    }

    // Get leaves by type (Sick, Casual...)
    public List<LeaveRequest> getLeavesByType(String leaveType) {
        return leaveRepository.findByLeaveType(leaveType);
    }

    // Update a leave application
    public LeaveRequest updateLeave(Long id, LeaveRequest updated) {
        LeaveRequest existing = getLeaveById(id);
        existing.setEmployeeName(updated.getEmployeeName());
        existing.setLeaveType(updated.getLeaveType());
        existing.setNumberOfDays(updated.getNumberOfDays());
        existing.setReason(updated.getReason());
        return leaveRepository.save(existing);
    }

    // Cancel a leave application
    public void cancelLeave(Long id) {
        LeaveRequest existing = getLeaveById(id);
        leaveRepository.delete(existing);
    }
}

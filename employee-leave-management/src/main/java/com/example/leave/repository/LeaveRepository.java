package com.example.leave.repository;

import com.example.leave.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Long> {

    // Spring writes the query for us from the method name
    List<LeaveRequest> findByLeaveType(String leaveType);
}

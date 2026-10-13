package com.example.leave.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

// One row = one leave application made by an employee
@Entity
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotBlank(message = "Employee name is required")
    private String employeeName;

    @NotBlank(message = "Leave type is mandatory")
    private String leaveType;          // e.g. Sick, Casual, Annual

    @Min(value = 1, message = "Leave days should be minimum 1")
    private int numberOfDays;

    private String reason;             // optional

    // Default constructor (needed by JPA)
    public LeaveRequest() {
    }

    public LeaveRequest(String employeeName, String leaveType, int numberOfDays, String reason) {
        this.employeeName = employeeName;
        this.leaveType = leaveType;
        this.numberOfDays = numberOfDays;
        this.reason = reason;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public String getLeaveType() { return leaveType; }
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }

    public int getNumberOfDays() { return numberOfDays; }
    public void setNumberOfDays(int numberOfDays) { this.numberOfDays = numberOfDays; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}

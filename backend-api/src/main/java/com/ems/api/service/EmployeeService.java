package com.ems.api.service;

import com.ems.api.dto.EmployeeDto;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface EmployeeService{

    EmployeeDto createNewEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmplyeeById(Long empId);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    String deleteEmployee(Long empId);

    EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto);
}

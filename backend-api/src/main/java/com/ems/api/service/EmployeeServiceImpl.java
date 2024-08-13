package com.ems.api.service;

import com.ems.api.dto.EmployeeDto;
import com.ems.api.entity.Employee;
import com.ems.api.repo.EmployeeRepo;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public EmployeeDto createNewEmployee(EmployeeDto employeeDto) {

        Employee emp = modelMapper.map(employeeDto, Employee.class);
        employeeRepo.save(emp);
        employeeDto = modelMapper.map(emp, EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public EmployeeDto getEmplyeeById(Long empId) {
        EmployeeDto employeeDto;
        Optional<Employee> employeeDetails = employeeRepo.findById(empId);
        employeeDto = modelMapper.map(employeeDetails, EmployeeDto.class);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeDto> EmpListDto = new ArrayList<>();
        List<Employee> empDetailsList = employeeRepo.findAll();
        for (Employee employee : empDetailsList) {
            EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
            EmpListDto.add(employeeDto);
        }
        return EmpListDto;
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepo.findById(updatedEmployee.getId());
        if (employeeOptional.isPresent()) {
            Employee employee = new Employee();
            employee.setId(updatedEmployee.getId());
            employee.setFirstName(updatedEmployee.getFirstName());
            employee.setLastName(updatedEmployee.getLastName());
            employee.setEmail(updatedEmployee.getEmail());
            employeeRepo.saveAndFlush(employee);
            modelMapper.map(employee, EmployeeDto.class);
            return updatedEmployee;
        } else {
            throw new EntityNotFoundException("Employee ID Not Found");
        }
    }

    @Override
    public EmployeeDto updateEmployeeById(Long employeeId, EmployeeDto employeeDto) {
        Optional<Employee> employeeOptional = employeeRepo.findById(employeeId);
        if (employeeOptional.isPresent()) {
            Employee employee = new Employee();
            employee.setId(employeeId);
            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setEmail(employeeDto.getEmail());
            employeeDto.setId(employeeId);
            employeeRepo.saveAndFlush(employee);
            modelMapper.map(employee, EmployeeDto.class);
            return employeeDto;
        } else {
            throw new EntityNotFoundException("Employee ID Not Found");
        }
    }

    @Override
    public String deleteEmployee(Long empId) {

        Optional<Employee> employee = employeeRepo.findById(empId);
        if (employee.isPresent()) {
            employeeRepo.deleteById(empId);
            return "Employee Deleted Successfully";
        } else {
            return "Employee Not Found";
        }
    }


}

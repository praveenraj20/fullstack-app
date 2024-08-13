package com.ems.api.controller;

import com.ems.api.dto.EmployeeDto;
import com.ems.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/v1/api/employee")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/createEmployee", produces = "application/json")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createNewEmployee(employeeDto), HttpStatus.OK);
    }

    @GetMapping(value = "/getEmployeeById", produces = "application/json")
    public ResponseEntity<EmployeeDto> getEmpById(@RequestParam Long empId) {
        return new ResponseEntity<>(employeeService.getEmplyeeById(empId), HttpStatus.OK);
    }

    @GetMapping(value = "/getAllEmployee", produces = "application/json")
    public ResponseEntity<List<EmployeeDto>> getAllEmp() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @PutMapping(value = "/updateEmployee", produces = "application/json")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDto), HttpStatus.OK);
    }

    @PutMapping(value = "/updateEmployeeById", produces = "application/json")
    public ResponseEntity<EmployeeDto> updateEmployeeByID(@RequestParam Long employeeId, @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.updateEmployeeById(employeeId,employeeDto),HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteEmployee", produces = "application/json")
    public ResponseEntity<String> deleteEmployee(@RequestParam Long empId) {

        return new ResponseEntity<>(employeeService.deleteEmployee(empId), HttpStatus.OK);
    }

}

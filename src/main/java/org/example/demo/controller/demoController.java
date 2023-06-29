package org.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.demo.entity.Employee;
import org.example.demo.model.EmployeeServiceResponse;
import org.example.demo.repository.EmployeeRepository;
import org.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
@Slf4j
public class demoController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("admin/getall")
    public EmployeeServiceResponse getAllEmployees(){
        EmployeeServiceResponse response = new EmployeeServiceResponse();
        List<Employee> employees=  employeeService.getallEmp();
        response.setData(employees);
        response.setCount(employees.size());
        return response;
    }

    @GetMapping("admin/alldept/{dept}/{gender}")
    public EmployeeServiceResponse getAllDept(@PathVariable String dept, @PathVariable String gender){
        EmployeeServiceResponse response = new EmployeeServiceResponse();
        List<Employee> employees=  employeeService.findAllDept(dept,gender);

        response.setData(employees);
        response.setCount(employees.size());
        return response;
    }

    @GetMapping("gethighsalary")
    public Employee getHighSalary(){
        return employeeService.getHighestSalary();
    }

    @GetMapping("getsalary/{n}")
    public Employee getnthSalary(@PathVariable Integer n){
        return employeeService.getHighestSalary(n);
    }

    @GetMapping("getcountry/{country}")
    public EmployeeServiceResponse getCountryWiseEmp(@PathVariable String country){
        EmployeeServiceResponse response = new EmployeeServiceResponse();
        log.info("getting all the empl for the country {}" ,country);
        List<Employee> employees=  employeeService.getCountryWiseEmp(country);
        response.setData(employees);
        response.setCount(employees.size());
        return response;
    }



}

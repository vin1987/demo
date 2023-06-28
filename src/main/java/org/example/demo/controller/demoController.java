package org.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.demo.entity.Employee;
import org.example.demo.repository.EmployeeRepository;
import org.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("getall")
    public List<Employee> getAllEmployees(){
        return employeeService.getallEmp();
    }

    @GetMapping("alldept/{dept}")
    public List<Employee> getAllDept(@PathVariable String dept){
        return employeeService.findAllDept(dept);
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
    public List<Employee> getCountryWiseEmp(@PathVariable String country){
        log.info("getting all the empl for the country {}" ,country);
        return employeeService.getCountryWiseEmp(country);
    }



}

package org.example.demo.service;

import org.example.demo.entity.Employee;
import org.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;



    @Cacheable("employees")
    public List<Employee> getallEmp(){

        List<Employee> allEmp = (List<Employee>) employeeRepository.findAll();
        List<Employee> result = allEmp.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
        return result;

    }

    public Employee getHighestSalary(){
        List<Employee> employees = getallEmp();
        Employee employee = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList()).get(1);
        return employee;

    }

    public Employee getHighestSalary(Integer n){
        List<Employee> employees = getallEmp();
        Employee employee = employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList()).get(n);
        return employee;

    }

    public List<Employee> getCountryWiseEmp(String country){
        List<Employee> employees = getallEmp();
        List<Employee> countryWiseEmp = employees.stream().filter(e -> e.getCountry().toLowerCase().equals(country)).collect(Collectors.toList());
        return countryWiseEmp;

    }

    public List<Employee> findAllDept(String dept) {
        return employeeRepository.findByDept(dept).stream().toList();
    }
}

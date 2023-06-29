package org.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.demo.entity.Employee;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceResponse {

    private int count;
    private List<Employee> data;
}

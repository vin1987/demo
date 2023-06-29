package org.example.demo.repository;

import org.example.demo.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    Collection<Employee> findByDept(String dept);
//    Collection<Employee> findByDeptCountry(String dept,String country);
//    Collection<Employee> findByDeptCountryGender(String dept,String country,String gender);

}

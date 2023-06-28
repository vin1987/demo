package org.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name="ID", nullable = false)
    private long id;
    @Column(name="FIRST_NAME")
    public String first_name;
    @Column(name="LAST_NAME")
    public String last_name;
    @Column(name="EMAIL")
    public String email;

    @Column(name="SALARY")
    public Integer salary;

    @Column(name="DEPT")
    public String dept;

    @Column(name="CITY")
    public String city;

    @Column(name="COUNTRY")
    public String country;

    @Column(name="GENDER")
    public String gender;

}

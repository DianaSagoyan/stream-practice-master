package com.cydeo.streampractice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class Employee {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate hireDate;
    private Job job;
    private Long salary;
    private Double commissionPCT;
    private Employee manager;
    private Department department;

    public Employee(Long id, String firstName, String lastName, String email, String phoneNumber, LocalDate hireDate, Job job, Long salary, Double commissionPCT) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.job = job;
        this.salary = salary;
        this.commissionPCT = commissionPCT;
    }

    @Override
    public String toString() {
        return "{" + id + ", " + firstName + ", " + lastName + ", " + email + ", " + phoneNumber + ", " + hireDate.toString() + ", " + job.getId() + ", " + salary + ", " + commissionPCT + ", " + manager.getId() + ", " + department.getDepartmentName() + "}";
    }

}

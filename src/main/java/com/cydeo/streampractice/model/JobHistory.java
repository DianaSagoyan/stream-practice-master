package com.cydeo.streampractice.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobHistory {

    private Employee employee;
    private LocalDate startDate;
    private LocalDate endDate;
    private Job job;
    private Department department;

    @Override
    public String toString() {
        return "{" + employee.getId() + ", " + startDate.toString() + ", " + endDate.toString() + ", " + job.getJobTitle() + ", " + department.getDepartmentName() + "}";
    }

}

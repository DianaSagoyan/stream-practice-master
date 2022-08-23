package com.cydeo.streampractice.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {

    private String id;
    private String jobTitle;
    private Long minSalary;
    private Long maxSalary;

    @Override
    public String toString() {
        return "{" + id + ", " + jobTitle + ", " + minSalary + ", " + maxSalary + "}";
    }

}

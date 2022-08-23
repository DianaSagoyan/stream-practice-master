package com.cydeo.streampractice.service;

import com.cydeo.streampractice.model.JobHistory;

import java.util.List;

public interface JobHistoryService {

    JobHistory create(JobHistory object);

    List<JobHistory> createAll(List<JobHistory> list);

    void update(JobHistory object);

    List<JobHistory> readAll();

    public List<JobHistory> readByEmployeeId(Long id);

    void delete(JobHistory object);

    public void deleteByEmployeeId(Long id);

}

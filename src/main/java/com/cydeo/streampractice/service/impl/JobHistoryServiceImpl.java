package com.cydeo.streampractice.service.impl;

import com.cydeo.streampractice.model.JobHistory;
import com.cydeo.streampractice.service.JobHistoryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobHistoryServiceImpl implements JobHistoryService {

    private final List<JobHistory> list = new ArrayList<>();

    /**
     * This method takes a JobHistory object as parameter,
     * and puts it into the List, which is the list variable created above.
     * At the end, it returns the object which it added into List.
     *
     * @param object JobHistory object
     * @return JobHistory object
     */
    @Override
    public JobHistory create(JobHistory object) {
        list.add(object);
        return object;
    }

    /**
     * This method takes a List of JobHistory objects as parameter,
     * and adds all of them into the List, which is the list variable created above.
     * At the end, it returns the List of JobHistory objects which it added into List.
     *
     * @param list List of JobHistory objects
     * @return List of JobHistory objects
     */
    @Override
    public List<JobHistory> createAll(List<JobHistory> list) {
        return list.stream().map(this::create).collect(Collectors.toList());
    }

    /**
     * This method takes a JobHistory object as parameter,
     * and updates the one that is already added earlier into the List, which is the list variable created above.
     * This method doesn't return anything after it updated the corresponding object in the List.
     *
     * @param object JobHistory object
     */
    @Override
    public void update(JobHistory object) {
        for (JobHistory jobHistory : list) {
            if (jobHistory.getEmployee().getId().equals(object.getEmployee().getId()) && jobHistory.getJob().getId().equals(object.getJob().getId())) {
                jobHistory.setEmployee(object.getEmployee());
                jobHistory.setStartDate(object.getStartDate());
                jobHistory.setEndDate(object.getEndDate());
                jobHistory.setJob(object.getJob());
                jobHistory.setDepartment(object.getDepartment());
            }
        }
    }

    /**
     * This method doesn't take any parameters,
     * It returns all the JobHistory objects inside the List created above, as List of JobHistory objects.
     *
     * @return List of JobHistory objects
     */
    @Override
    public List<JobHistory> readAll() {
        return list;
    }

    /**
     * This method takes a Long object as parameter,
     * It returns the JobHistory object where its Employee has an id equals the id coming from the method parameter, from the List created above.
     *
     * @param id Employee id as a Long object
     * @return JobHistory object
     */
    @Override
    public List<JobHistory> readByEmployeeId(Long id) {
        return list.stream().filter(jobHistory -> jobHistory.getEmployee().getId().equals(id)).collect(Collectors.toList());
    }

    /**
     * This method takes a JobHistory object as parameter,
     * and removes the JobHistory object which is equals the Country object coming from the method parameter, from the List created above.
     * This method doesn't return anything after it removed the corresponding object in the List.
     *
     * @param object JobHistory object
     */
    @Override
    public void delete(JobHistory object) {
        list.remove(object);
    }

    /**
     * This method takes a Long object as parameter,
     * and removes the JobHistory object where its Employee has an id equals the id coming from the method parameter, from the List created above.
     * This method doesn't return anything after it removed the corresponding object in the List.
     *
     * @param id Employee id as a String object
     */
    @Override
    public void deleteByEmployeeId(Long id) {
        list.removeIf(jobHistory -> jobHistory.getEmployee().getId().equals(id));
    }

}

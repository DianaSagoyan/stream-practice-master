package com.cydeo.streampractice.service.impl;

import com.cydeo.streampractice.model.Job;
import com.cydeo.streampractice.service.JobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl extends CrudServiceImpl<Job, String> implements JobService {

    /**
     * This method takes a Job object as parameter,
     * and puts it into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the object which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Job object
     * @return Job object
     */
    @Override
    public Job create(Job object) {
        return super.create(object.getId(), object);
    }

    /**
     * This method takes a List of Job objects as parameter,
     * and puts all of them into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the List of Job objects which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param list List of Job objects
     * @return List of Job objects
     */
    @Override
    public List<Job> createAll(List<Job> list) {
        return list.stream().map(this::create).collect(Collectors.toList());
    }

    /**
     * This method takes a Job object as parameter,
     * and updates the one that is already put earlier into the Map, which is in the CrudServiceImpl class.
     * This method doesn't return anything after it updated the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Job object
     */
    @Override
    public void update(Job object) {
        super.update(object.getId(), object);
    }

    /**
     * This method doesn't take any parameters,
     * It returns all the Job objects inside the Map in the CrudServiceImpl class as List of Job objects.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @return List of Job objects
     */
    @Override
    public List<Job> readAll() {
        return super.readAll();
    }

    /**
     * This method takes a String object as parameter,
     * and removes the Job object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Job id as a String object
     */
    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    /**
     * This method takes a Job object as parameter,
     * and removes the Job object which is equals the Job object coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Job object
     */
    @Override
    public void delete(Job object) {
        super.delete(object);
    }

    /**
     * This method takes a String object as parameter,
     * It returns the Job object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Job id as a String object
     * @return Job object
     */
    @Override
    public Job readById(String id) {
        return super.readById(id);
    }

}

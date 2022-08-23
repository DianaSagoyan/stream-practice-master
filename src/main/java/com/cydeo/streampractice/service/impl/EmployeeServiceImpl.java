package com.cydeo.streampractice.service.impl;

import com.cydeo.streampractice.model.Employee;
import com.cydeo.streampractice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl extends CrudServiceImpl<Employee, Long> implements EmployeeService {

    /**
     * This method takes an Employee object as parameter,
     * and puts it into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the object which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Employee object
     * @return Employee object
     */
    @Override
    public Employee create(Employee object) {
        return super.create(object.getId(), object);
    }

    /**
     * This method takes a List of Employee objects as parameter,
     * and puts all of them into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the List of Employee objects which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param list List of Employee objects
     * @return List of Employee objects
     */
    @Override
    public List<Employee> createAll(List<Employee> list) {
        return list.stream().map(this::create).collect(Collectors.toList());
    }

    /**
     * This method takes an Employee object as parameter,
     * and updates the one that is already put earlier into the Map, which is in the CrudServiceImpl class.
     * This method doesn't return anything after it updated the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Employee object
     */
    @Override
    public void update(Employee object) {
        super.update(object.getId(), object);
    }

    /**
     * This method doesn't take any parameters,
     * It returns all the Employee objects inside the Map in the CrudServiceImpl class as List of Employee objects.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @return List of Employee objects
     */
    @Override
    public List<Employee> readAll() {
        return super.readAll();
    }

    /**
     * This method takes a Long object as parameter,
     * and removes the Employee object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Employee id as a Long object
     */
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    /**
     * This method takes an Employee object as parameter,
     * and removes the Employee object which is equals the Employee object coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Employee object
     */
    @Override
    public void delete(Employee object) {
        super.delete(object);
    }

    /**
     * This method takes a Long object as parameter,
     * It returns the Employee object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Job id as a Long object
     * @return Employee object
     */
    @Override
    public Employee readById(Long id) {
        return super.readById(id);
    }

}

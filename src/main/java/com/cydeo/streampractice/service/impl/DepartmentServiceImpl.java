package com.cydeo.streampractice.service.impl;

import com.cydeo.streampractice.model.Department;
import com.cydeo.streampractice.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl extends CrudServiceImpl<Department, Long> implements DepartmentService {

    /**
     * This method takes a Department object as parameter,
     * and puts it into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the object which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Department object
     * @return Department object
     */
    @Override
    public Department create(Department object) {
        return super.create(object.getId(), object);
    }

    /**
     * This method takes a List of Department objects as parameter,
     * and puts all of them into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the List of Department objects which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param list List of Department objects
     * @return List of Department objects
     */
    @Override
    public List<Department> createAll(List<Department> list) {
        return list.stream().map(this::create).collect(Collectors.toList());
    }

    /**
     * This method takes a Department object as parameter,
     * and updates the one that is already put earlier into the Map, which is in the CrudServiceImpl class.
     * This method doesn't return anything after it updated the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Department object
     */
    @Override
    public void update(Department object) {
        super.update(object.getId(), object);
    }

    /**
     * This method doesn't take any parameters,
     * It returns all the Department objects inside the Map in the CrudServiceImpl class as List of Department objects.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @return List of Department objects
     */
    @Override
    public List<Department> readAll() {
        return super.readAll();
    }

    /**
     * This method takes a Long object as parameter,
     * and removes the Department object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Department id as a Long object
     */
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    /**
     * This method takes a Department object as parameter,
     * and removes the Department object which is equals the Department object coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Department object
     */
    @Override
    public void delete(Department object) {
        super.delete(object);
    }

    /**
     * This method takes a Long object as parameter,
     * It returns the Department object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Job id as a Long object
     * @return Department object
     */
    @Override
    public Department readById(Long id) {
        return super.readById(id);
    }

}

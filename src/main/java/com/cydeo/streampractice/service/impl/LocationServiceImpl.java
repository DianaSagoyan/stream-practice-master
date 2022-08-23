package com.cydeo.streampractice.service.impl;

import com.cydeo.streampractice.model.Location;
import com.cydeo.streampractice.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl extends CrudServiceImpl<Location, Long> implements LocationService {

    /**
     * This method takes a Location object as parameter,
     * and puts it into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the object which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Location object
     * @return Location object
     */
    @Override
    public Location create(Location object) {
        return super.create(object.getId(), object);
    }

    /**
     * This method takes a List of Location objects as parameter,
     * and puts all of them into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the List of Location objects which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param list List of Location objects
     * @return List of Location objects
     */
    @Override
    public List<Location> createAll(List<Location> list) {
        return list.stream().map(this::create).collect(Collectors.toList());
    }

    /**
     * This method takes a Location object as parameter,
     * and updates the one that is already put earlier into the Map, which is in the CrudServiceImpl class.
     * This method doesn't return anything after it updated the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Location object
     */
    @Override
    public void update(Location object) {
        super.update(object.getId(), object);
    }

    /**
     * This method doesn't take any parameters,
     * It returns all the Location objects inside the Map in the CrudServiceImpl class as List of Location objects.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @return List of Location objects
     */
    @Override
    public List<Location> readAll() {
        return super.readAll();
    }

    /**
     * This method takes a Long object as parameter,
     * and removes the Location object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Location id as a Long object
     */
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    /**
     * This method takes a Location object as parameter,
     * and removes the Location object which is equals the Location object coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Location object
     */
    @Override
    public void delete(Location object) {
        super.delete(object);
    }

    /**
     * This method takes a Long object as parameter,
     * It returns the Location object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Location id as a Long object
     * @return Location object
     */
    @Override
    public Location readById(Long id) {
        return super.readById(id);
    }

}

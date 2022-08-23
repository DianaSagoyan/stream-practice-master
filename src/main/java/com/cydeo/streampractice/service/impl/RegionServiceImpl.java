package com.cydeo.streampractice.service.impl;

import com.cydeo.streampractice.model.Region;
import com.cydeo.streampractice.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegionServiceImpl extends CrudServiceImpl<Region, Long> implements RegionService {

    /**
     * This method takes a Region object as parameter,
     * and puts it into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the object which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Region object
     * @return Region object
     */
    @Override
    public Region create(Region object) {
        return super.create(object.getId(), object);
    }

    /**
     * This method takes a List of Region objects as parameter,
     * and puts all of them into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the List of Region objects which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param list List of Region objects
     * @return List of Region objects
     */
    @Override
    public List<Region> createAll(List<Region> list) {
        return list.stream().map(this::create).collect(Collectors.toList());
    }

    /**
     * This method takes a Region object as parameter,
     * and updates the one that is already put earlier into the Map, which is in the CrudServiceImpl class.
     * This method doesn't return anything after it updated the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Region object
     */
    @Override
    public void update(Region object) {
        super.update(object.getId(), object);
    }

    /**
     * This method doesn't take any parameters,
     * It returns all the Region objects inside the Map in the CrudServiceImpl class as List of Region objects.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @return List of Region objects
     */
    @Override
    public List<Region> readAll() {
        return super.readAll();
    }

    /**
     * This method takes a Long object as parameter,
     * and removes the Region object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Region id as a Long object
     */
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    /**
     * This method takes a Region object as parameter,
     * and removes the Region object which is equals the Region object coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Region object
     */
    @Override
    public void delete(Region object) {
        super.delete(object);
    }

    /**
     * This method takes a Long object as parameter,
     * It returns the Region object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Region id as a Long object
     * @return Region object
     */
    @Override
    public Region readById(Long id) {
        return super.readById(id);
    }

}

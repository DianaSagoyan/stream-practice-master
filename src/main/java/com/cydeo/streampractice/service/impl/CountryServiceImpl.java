package com.cydeo.streampractice.service.impl;

import com.cydeo.streampractice.model.Country;
import com.cydeo.streampractice.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl extends CrudServiceImpl<Country, String> implements CountryService {

    /**
     * This method takes a Country object as parameter,
     * and puts it into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the object which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Country object
     * @return Country object
     */
    @Override
    public Country create(Country object) {
        return super.create(object.getId(), object);
    }

    /**
     * This method takes a List of Country objects as parameter,
     * and puts all of them into the Map, which is in the CrudServiceImpl class.
     * At the end, it returns the List of Country objects which it put into Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param list List of Country objects
     * @return List of Country objects
     */
    @Override
    public List<Country> createAll(List<Country> list) {
        return list.stream().map(this::create).collect(Collectors.toList());
    }

    /**
     * This method takes a Country object as parameter,
     * and updates the one that is already put earlier into the Map, which is in the CrudServiceImpl class.
     * This method doesn't return anything after it updated the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Country object
     */
    @Override
    public void update(Country object) {
        super.update(object.getId(), object);
    }

    /**
     * This method doesn't take any parameters,
     * It returns all the Country objects inside the Map in the CrudServiceImpl class as List of Country objects.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @return List of Country objects
     */
    @Override
    public List<Country> readAll() {
        return super.readAll();
    }

    /**
     * This method takes a String object as parameter,
     * and removes the Country object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Country id as a String object
     */
    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    /**
     * This method takes a Country object as parameter,
     * and removes the Country object which is equals the Country object coming from the method parameter, from the Map in the CrudServiceImpl class.
     * This method doesn't return anything after it removed the corresponding object in the Map.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param object Country object
     */
    @Override
    public void delete(Country object) {
        super.delete(object);
    }

    /**
     * This method takes a String object as parameter,
     * It returns the Country object which has an id equals the id coming from the method parameter, from the Map in the CrudServiceImpl class.
     *
     * The Map mentioned above -> {@link com.cydeo.streampractice.service.impl.CrudServiceImpl#map}
     * @param id Job id as a String object
     * @return Country object
     */
    @Override
    public Country readById(String id) {
        return super.readById(id);
    }

}

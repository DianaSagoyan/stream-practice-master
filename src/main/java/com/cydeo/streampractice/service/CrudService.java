package com.cydeo.streampractice.service;

import java.util.List;

public interface CrudService<T, ID> {

    T create(T object);

    List<T> createAll(List<T> list);

    void update(T object);

    List<T> readAll();

    T readById(ID id);

    void delete(T object);

    void deleteById(ID id);

}

package edu.javavt16.dao;

import edu.javavt16.model.CarModel;

import java.util.List;

public interface CarModelDAO {

    void saveOrUpdate(CarModel item);

    void delete(int itemId);

    CarModel get(int itemId);

    List<CarModel> list();

}
package edu.javavt16.service;

import edu.javavt16.model.CarModel;
import java.util.List;

public interface CarModelService {
    void saveOrUpdate(CarModel item);

    void delete(int itemId);

    CarModel get(int itemId);

    List<CarModel> list();
}
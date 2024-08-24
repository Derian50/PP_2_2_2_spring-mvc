package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.List;

@Service
public class CarServiceImp implements CarService{
    @Override
    public List<Car> returnCars(List<Car> cars, int count) {
        return cars.subList(0, Math.min(count, 5));
    }
}

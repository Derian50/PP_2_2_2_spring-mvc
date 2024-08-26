package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService{
    @Override

    public List<Car> returnCars(int count) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tesla", 11, 2020));
        cars.add(new Car("Audi", 22, 2012));
        cars.add(new Car("BMV", 33, 2007));
        cars.add(new Car("Ferrari", 44, 2024));
        cars.add(new Car("Porsche", 55, 1999));

        return cars.subList(0, Math.min(count, 5));
    }
}

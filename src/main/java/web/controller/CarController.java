package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import web.config.WebConfig;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
	@Autowired
	CarService carService;
	@GetMapping(value = "/cars")
	public String printWelcome(ModelMap model, @RequestParam(defaultValue = "5") int count) {


		List<Car> cars = new ArrayList<>();
		cars.add(new Car("Tesla", 11, 2020));
		cars.add(new Car("Audi", 22, 2012));
		cars.add(new Car("BMV", 33, 2007));
		cars.add(new Car("Ferrari", 44, 2024));
		cars.add(new Car("Porsche", 55, 1999));

		model.addAttribute("cars", carService.returnCars(cars, count));
		return "cars";
	}
	
}
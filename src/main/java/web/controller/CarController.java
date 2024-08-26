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
	private CarService carService;
	@GetMapping(value = "/cars")
	public String printWelcome(ModelMap model, @RequestParam(defaultValue = "5") int count) {
		model.addAttribute("cars", carService.returnCars(count));
		return "cars";
	}
	
}
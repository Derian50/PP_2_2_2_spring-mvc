package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@GetMapping(value = "/")
	public String printUsersTable(ModelMap model) {
		List<User> users = userService.getUsers();
		model.addAttribute("users", users);

		return "index";
	}
	@GetMapping(value = "/add")
	public String addUser(ModelMap model) {
		model.addAttribute("user", new User());
		return "add";
	}

	@PostMapping("/add")
	public String addUser(User user) {
		userService.add(user);
		return "redirect:/";
	}
	@GetMapping(value = "/update")
	public String updateUser(@RequestParam(value = "id") int id, ModelMap model) {
		model.addAttribute("user", userService.getUserById(id));
		return "update";
	}

	@PostMapping("/update")
	public String updateUser(User user) {
		userService.update(user);
		return "redirect:/";
	}

	@PostMapping("/delete")
	public String deleteUser(@RequestParam(value = "id") int id) {
		userService.remove(userService.getUserById(id));
		return "redirect:/";
	}
	
}
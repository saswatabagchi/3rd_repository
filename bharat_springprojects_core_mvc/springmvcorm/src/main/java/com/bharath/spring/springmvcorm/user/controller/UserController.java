package com.bharath.spring.springmvcorm.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bharath.spring.springmvcorm.user.entity.User;
import com.bharath.spring.springmvcorm.user.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("registrationPage")
	public String showRegistrationPage() {
		return "userReg";
	}

	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, ModelMap model) {
		int result = service.save(user);
		model.addAttribute("result", "User Created With Id" + result);

		return "userReg";
	}

	@RequestMapping("getUsers")
	public String getUser(ModelMap model) {
		List<User> users = service.getUsers();
		model.addAttribute("users", users);
		return "displayUsers";
	}

	@RequestMapping("validateEmail")
	public @ResponseBody String validateEmail(@RequestParam("id") int id) {
		User user = service.getUser(id);
		String msg = "";

		if (user != null) {
			msg = id + " already exists";
		}
		return msg;

	}

	public UserService getService() {
		return service;
	}

	public void setService(UserService service) {
		this.service = service;
	}

}

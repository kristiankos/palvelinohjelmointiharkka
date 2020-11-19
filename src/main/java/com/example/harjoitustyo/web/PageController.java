package com.example.harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.harjoitustyo.domain.CityRepository;
import com.example.harjoitustyo.domain.ParkRepository;
import com.example.harjoitustyo.domain.SignupForm;


@Controller
public class PageController {
	
	@Autowired
	private ParkRepository parkrepo;
	
	@Autowired
	private CityRepository cityrepo;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("parks", parkrepo.findAll());
		model.addAttribute("cities", cityrepo.findAll());
		return "index";
	}
	
	@GetMapping("/citypage")
	public String cityPage(Model model) {
		model.addAttribute("parks", parkrepo.findAll());
		model.addAttribute("cities", cityrepo.findAll());
		return "citypage";
	}
	
	@RequestMapping(value = "/signup")
	public String addUser(Model model) {
		model.addAttribute("signupform", new SignupForm());
		return "signup";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
}

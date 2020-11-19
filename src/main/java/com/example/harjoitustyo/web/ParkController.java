package com.example.harjoitustyo.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.harjoitustyo.domain.CityRepository;
import com.example.harjoitustyo.domain.Park;
import com.example.harjoitustyo.domain.ParkRepository;


@Controller
public class ParkController {

	@Autowired
	private ParkRepository parkrepo;
	
	@Autowired
	private CityRepository cityrepo;

	
	// RESTful service to get all parks
    @GetMapping(value="/parks")
    public @ResponseBody List<Park> parkListRest() {	
        return (List<Park>) parkrepo.findAll();
    } 
    
    //RESTful service to save new park
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/parks")
    public Park saveParkRest(@RequestBody Park park) {
    	return parkrepo.save(park);
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/save")
	public String save(@Valid Park park, BindingResult bindingResult, Model model) {
    	if(bindingResult.hasErrors()) {
    		model.addAttribute("cities", cityrepo.findAll());
    		return "parkform";
    	} else {
		parkrepo.save(park);
		return "redirect:/";
    	}
	}
	

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/delete/{parkid}")
	public String deletePark(@PathVariable("parkid") Long parkId, Model model) {
		parkrepo.deleteById(parkId);
		return "redirect:/";
	}

	@GetMapping(value = "/parks/{parkid}")
	public @ResponseBody Optional<Park> findParkById(@PathVariable("parkid") Long parkId, Model model) {
		model.addAttribute("cities", cityrepo.findAll());
		return parkrepo.findById(parkId);
	}
	

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping(value = "/newpark")
	public String newPark(Model model) {
		model.addAttribute("park", new Park());
		model.addAttribute("cities", cityrepo.findAll());
		return "parkform";
	}
	
}



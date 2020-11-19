package com.example.harjoitustyo.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.harjoitustyo.domain.SignupForm;
import com.example.harjoitustyo.domain.User;
import com.example.harjoitustyo.domain.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userrepo;
	
	@RequestMapping(value = "saveuser", method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("signupform") SignupForm signupForm, BindingResult bindingResult) {

		if (!bindingResult.hasErrors()) {
			if (signupForm.getPassword().equals(signupForm.getPasswordCheck())) {
				String password = signupForm.getPassword();
				BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
				String hashPassword = bc.encode(password);

				User newUser = new User();
				newUser.setPasswordHash(hashPassword);
				newUser.setUsername(signupForm.getUsername());
				newUser.setRole("USER");
				if (userrepo.findByUsername(signupForm.getUsername()) == null) {
					userrepo.save(newUser);
				} else {
					bindingResult.rejectValue("username", "err.username", "Käyttäjätunnus on jo olemassa!");
					return "signup";
				}

			} else {
				bindingResult.rejectValue("passwordCheck", "err.passCheck", "Salasanat eivät täsmää!");
				return "signup";
			}

		} else {
			return "signup";
		}

		return "redirect:/login";
	}

}

package com.xoxo.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xoxo.login.model.User;
import com.xoxo.login.service.EmailService;

@Controller
public class HomeController {
private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    private EmailService emailService;

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}
	
	@RequestMapping("/")
	public String home(){
		return "index";
	}
	
	@RequestMapping("/bloggers")
	public String bloggers(){
		return "bloggers";
	}
	
	@RequestMapping("/stories")
	public String stories(){
		return "stories";
	}
	
	@RequestMapping("/registration")
	public String registration(Model model){
		model.addAttribute("user", new User());
		return "registration";
	}
	
//	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	@PostMapping("/reg")
    public String greetingSubmit(@ModelAttribute User user) {
		log.info("Uj user!");
		emailService.sendMessage(user.getEmail());
//		log.debug(user.getUsername());
//		log.debug(user.getPassword());
        return "auth/login";
    }
}




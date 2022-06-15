package com.example.demo.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {
	
@RequestMapping("/") 
public String hello ( ) {
	return "index";
}

@RequestMapping("/time")
public String time(Model model) {
    model.addAttribute("dt", LocalDateTime.now());
    return "time";
}


}

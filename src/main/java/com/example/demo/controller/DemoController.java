package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/demo")
public class DemoController {
//	@RequestMapping(path = "/hi", method=RequestMethod.GET)
	@GetMapping("/hi")
	public String sayHi(){
		Category category = new Category();
		return("Mother Earth");
	}
	@GetMapping("/hello")
	public String sayHello() {
		return("Hello World");
	}

}

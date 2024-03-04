package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepo userRepo;
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user){
		User savedEntity = userRepo.saveAndFlush(user);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(savedEntity);
	}
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUser(@PathVariable int id){
		User user = userRepo.findById(id).get();
		UserDto dto = new UserDto(user.getId(), user.getUsername(), user.getEmail());
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(dto);
		
	}

}

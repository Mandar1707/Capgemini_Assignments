package com.carwash.usermanipulation.resource;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.usermanipulation.model.User;
import com.carwash.usermanipulation.repository.UserRepository;


@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostMapping("/addUser")
	public String saveUser(@RequestBody User user) {
		repository.save(user);
		return "User added : " + user.getId();
	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
		repository.save(user);
		return "User updated : " + user.getId();
	}
	
	
	@GetMapping("/findAllUsers")
	public List<User> getUser() {
		return repository.findAll();
	}

	@GetMapping("/findAllUsers/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return repository.findById(id);
	}

}

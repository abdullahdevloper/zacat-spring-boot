package com.CommunityCommittees.zakat.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CommunityCommittees.zakat.Entity.User;
import com.CommunityCommittees.zakat.Services.Interface.UserService;


@RequestMapping()
// @RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@Validated
@RestController
public class UserController {

	private  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

	// @GetMapping("/employees")
	// public Iterable<Employee> findAllEmployees() {
	//   return this.employeeRepository.findAll();
	// }
    //  http://localhost:8080/api/v1/users
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		System.out.print("helllllloooooooooooooo");

			return userService.getAllUsers();
	}



	//  http://localhost:8080/api/v1/users/1
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
		return userService.getUserById(id);
	}


	//  http://localhost:8080/api/v1/users
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	//  http://localhost:8080/api/v1/users/1
	@PutMapping("/users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}

	//  http://localhost:8080/api/v1/users/1
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Integer id) {
		return userService.deleteUser(id);
	}


}
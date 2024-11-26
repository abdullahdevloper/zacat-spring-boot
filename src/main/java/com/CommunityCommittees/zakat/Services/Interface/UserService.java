package com.CommunityCommittees.zakat.Services.Interface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CommunityCommittees.zakat.Entity.User;

import java.util.List;

public interface UserService {

     ResponseEntity<List<User>> getAllUsers();

     ResponseEntity<User> getUserById(Integer id);

     ResponseEntity<User> createUser(User User);

     ResponseEntity<User> updateUser(Integer id, User user);

     ResponseEntity<HttpStatus> deleteUser(Integer id);



}

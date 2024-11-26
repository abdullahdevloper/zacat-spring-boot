package com.CommunityCommittees.zakat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CommunityCommittees.zakat.Entity.User;
import com.CommunityCommittees.zakat.Repository.UserRepo;
import com.CommunityCommittees.zakat.Services.Interface.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;

    public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = new ArrayList<>();

                userRepository.findAll().forEach(users::add);
           

            if (users.isEmpty()) {
                
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            // return ResponseEntity.ok(users);

            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> getUserById(Integer id) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> createUser(User user) {
        try {
            User userObj = userRepository.save(user);
            return new ResponseEntity<>(userObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<User> updateUser(Integer id, User user) {
        Optional<User> userData = userRepository.findById(id);

        if (userData.isPresent()) {
            User userObj = userData.get();
            userObj.setUser_name(user.getUser_name());
            userObj.setFull_name(user.getFull_name());
            userObj.setMembersData(user.getMembersData());
            userObj.setMembersJob(user.getMembersJob());
            userObj.setPassword(user.getPassword());
            userObj.setStatus(user.getStatus());
            userObj.setSuspendMembers(user.getSuspendMembers());
            userObj.setAdd_date(user.getAdd_date());
            userObj.setAdd_by(user.getAdd_by());

            return new ResponseEntity<>(userRepository.save(userObj), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteUser(Integer id) {
        try {
            userRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

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

import com.CommunityCommittees.zakat.Entity.SuspendMembers;
import com.CommunityCommittees.zakat.Services.Interface.SuspendMembersService;

import lombok.RequiredArgsConstructor;

@RequestMapping( )
@RequiredArgsConstructor
@Validated
@CrossOrigin("http://localhost:3000")
@RestController
public class SuspendMembersController {

	private SuspendMembersService suspendMembersService;

    public SuspendMembersController(SuspendMembersService suspendMembersService) {
        this.suspendMembersService = suspendMembersService;
    }


    //  http://localhost:8080/api/suspendMembers
	@GetMapping("/suspendMembers")
	public ResponseEntity<List<SuspendMembers>> getAllSuspendMembers() {
			return suspendMembersService.getAllSuspendMembers();
	}

	//  http://localhost:8080/api/suspendMembers/1
	@GetMapping("/suspendMembers/{id}")
	public ResponseEntity<SuspendMembers> getSuspendMembersById(@PathVariable("id") Integer id) {
		return suspendMembersService.getSuspendMembersById(id);
	}


	//  http://localhost:8080/api/suspendMembers
	@PostMapping("/suspendMembers")
	public ResponseEntity<SuspendMembers> createSuspendMembers(@RequestBody SuspendMembers suspendMembers) {
		return suspendMembersService.createSuspendMembers(suspendMembers);
	}

	//  http://localhost:8080/api/suspendMembers/1
	@PutMapping("/suspendMembers/{id}")
	public ResponseEntity<SuspendMembers> updateSuspendMembers(@PathVariable("id") Integer id, @RequestBody SuspendMembers suspendMembers) {
		return suspendMembersService.updateSuspendMembers(id, suspendMembers);
	}

	//  http://localhost:8080/api/suspendMembers/1
	@DeleteMapping("/suspendMembers/{id}")
	public ResponseEntity<HttpStatus> deleteSuspendMembers(@PathVariable("id") Integer id) {
		return suspendMembersService.deleteSuspendMembers(id);
	}


}
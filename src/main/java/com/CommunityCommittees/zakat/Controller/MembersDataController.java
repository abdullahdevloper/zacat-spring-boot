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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CommunityCommittees.zakat.Entity.MembersData;
import com.CommunityCommittees.zakat.Services.Interface.MembersDataService;

import lombok.RequiredArgsConstructor;

@RequestMapping( )
@RequiredArgsConstructor
@Validated
@RestController
@CrossOrigin("http://localhost:3000")
public class MembersDataController {

	private MembersDataService membersDataService;

    public MembersDataController(MembersDataService membersDataService) {
        this.membersDataService = membersDataService;
    }


    //  http://localhost:8080/api/membersData
	@GetMapping("/membersData")
	public ResponseEntity<List<MembersData>> getAllMembersDatas() {
			return membersDataService.getAllMembersData();
	}

	//  http://localhost:8080/api/membersData/1
	@GetMapping("/membersData/{id}")
	public ResponseEntity<MembersData> getMembersDataById(@PathVariable("id") Integer id) {
		return membersDataService.getMembersDataById(id);
	}


	//  http://localhost:8080/api/membersData
	@PostMapping("/membersData")
	public ResponseEntity<MembersData> createMembersData(@RequestBody MembersData membersData) {
		return membersDataService.createMembersData(membersData);
	}

	//  http://localhost:8080/api/membersData/1
	@PutMapping("/membersData/{id}")
	public ResponseEntity<MembersData> updateMembersData(@PathVariable("id") Integer id, @RequestBody MembersData membersData) {
		return membersDataService.updateMembersData(id, membersData);
	}

	//  http://localhost:8080/api/membersData/1
	@DeleteMapping("/membersData/{id}")
	public ResponseEntity<HttpStatus> deleteMembersData(@PathVariable("id") Integer id) {
		return membersDataService.deleteMembersData(id);
	}


}
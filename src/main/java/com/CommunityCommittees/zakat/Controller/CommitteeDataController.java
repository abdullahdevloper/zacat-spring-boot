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

import com.CommunityCommittees.zakat.Entity.CommitteeData;
import com.CommunityCommittees.zakat.Services.Interface.CommitteeDataService;

import lombok.RequiredArgsConstructor;

@RequestMapping( )
@RequiredArgsConstructor
@Validated
@CrossOrigin("http://localhost:3000")
@RestController
public class CommitteeDataController {

	private CommitteeDataService committeeDataService;

    public CommitteeDataController(CommitteeDataService committeeDataService) {
        this.committeeDataService = committeeDataService;
    }


    //  http://localhost:8080/api/committeeData
	@GetMapping("/committeeData")
	public ResponseEntity<List<CommitteeData>> getAllCommitteeData() {
			return committeeDataService.getAllCommitteeData();
	}

	//  http://localhost:8080/api/committeeData/1
	@GetMapping("/committeeData/{id}")
	public ResponseEntity<CommitteeData> getCommitteeDataById(@PathVariable("id") Integer id) {
		return committeeDataService.getCommitteeDataById(id);
	}


	//  http://localhost:8080/api/committeeData
	@PostMapping("/committeeData")
	public ResponseEntity<CommitteeData> createCommitteeData(@RequestBody CommitteeData committeeData) {
		return committeeDataService.createCommitteeData(committeeData);
	}

	//  http://localhost:8080/api/committeeData/1
	@PutMapping("/committeeData/{id}")
	public ResponseEntity<CommitteeData> updateCommitteeData(@PathVariable("id") Integer id, @RequestBody CommitteeData committeeData) {
		return committeeDataService.updateCommitteeData(id, committeeData);
	}

	//  http://localhost:8080/api/committeeData/1
	@DeleteMapping("/committeeData/{id}")
	public ResponseEntity<HttpStatus> deleteCommitteeData(@PathVariable("id") Integer id) {
		return committeeDataService.deleteCommitteeData(id);
	}


}
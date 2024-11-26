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

import com.CommunityCommittees.zakat.Entity.CommitteeMembers;
import com.CommunityCommittees.zakat.Services.Interface.CommitteeMembersService;

import lombok.RequiredArgsConstructor;

@RequestMapping( )
@RequiredArgsConstructor
@Validated
@CrossOrigin("http://localhost:3000")
@RestController
public class CommitteeMembersController {

	private CommitteeMembersService committeeMembersService;

    public CommitteeMembersController(CommitteeMembersService committeeMembersService) {
        this.committeeMembersService = committeeMembersService;
    }


    //  http://localhost:8080/api/committeeMembers
	@GetMapping("/committeeMembers")
	public ResponseEntity<List<CommitteeMembers>> getAllCommitteeMembers() {
			return committeeMembersService.getAllCommitteeMembers();
	}

	//  http://localhost:8080/api/committeeMembers/1
	@GetMapping("/committeeMembers/{id}")
	public ResponseEntity<CommitteeMembers> getCommitteeMembersById(@PathVariable("id") Integer id) {
		return committeeMembersService.getCommitteeMembersById(id);
	}


	//  http://localhost:8080/api/committeeMembers
	@PostMapping("/committeeMembers")
	public ResponseEntity<CommitteeMembers> createCommitteeMembers(@RequestBody CommitteeMembers committeeMembers) {
		return committeeMembersService.createCommitteeMembers(committeeMembers);
	}

	//  http://localhost:8080/api/committeeMembers/1
	@PutMapping("/committeeMembers/{id}")
	public ResponseEntity<CommitteeMembers> updateCommitteeMembers(@PathVariable("id") Integer id, @RequestBody CommitteeMembers committeeMembers) {
		return committeeMembersService.updateCommitteeMembers(id, committeeMembers);
	}

	//  http://localhost:8080/api/committeeMembers/1
	@DeleteMapping("/committeeMembers/{id}")
	public ResponseEntity<HttpStatus> deleteCommitteeMembers(@PathVariable("id") Integer id) {
		return committeeMembersService.deleteCommitteeMembers(id);
	}


}
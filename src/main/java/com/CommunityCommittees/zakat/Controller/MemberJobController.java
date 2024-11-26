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

import com.CommunityCommittees.zakat.Entity.MemberJob;
import com.CommunityCommittees.zakat.Services.Interface.MemberJobService;

import lombok.RequiredArgsConstructor;

@RequestMapping( )
// @RequiredArgsConstructor
@Validated
@CrossOrigin("http://localhost:3000")
@RestController
public class MemberJobController {

	private MemberJobService memberJobService;

    public MemberJobController(MemberJobService memberJobService) {
        this.memberJobService = memberJobService;
    }


    //  http://localhost:8080/api/memberJob
	@GetMapping("/memberJob")
	public ResponseEntity<List<MemberJob>> getAllMemberJobs() {

			return memberJobService.getAllMemberJobs();
	}

	//  http://localhost:8080/api/memberJob/1
	@GetMapping("/memberJob/{id}")
	public ResponseEntity<MemberJob> getMemberJobById(@PathVariable("id") Integer id) {
		return memberJobService.getMemberJobById(id);
	}


	//  http://localhost:8080/api/memberJob
	@PostMapping("/memberJob")
	public ResponseEntity<MemberJob> createMemberJob(@RequestBody MemberJob memberJob) {

		return memberJobService.createMemberJob(memberJob);
	}

	//  http://localhost:8080/api/memberJob/1
	@PutMapping("/memberJob/{id}")
	public ResponseEntity<MemberJob> updateMemberJob(@PathVariable("id") Integer id, @RequestBody MemberJob memberJob) {
		return memberJobService.updateMemberJob(id, memberJob);
	}

	//  http://localhost:8080/api/memberJob/1
	@DeleteMapping("/memberJob/{id}")
	public ResponseEntity<HttpStatus> deleteMemberJob(@PathVariable("id") Integer id) {
		return memberJobService.deleteMemberJob(id);
	}


}
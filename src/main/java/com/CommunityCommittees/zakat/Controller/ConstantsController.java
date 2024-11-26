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

import com.CommunityCommittees.zakat.Entity.Constants;
import com.CommunityCommittees.zakat.Services.Interface.ConstantsService;


@RequestMapping( )
// @RequiredArgsConstructor
@Validated
@RestController
@CrossOrigin("http://localhost:3000")
public class ConstantsController {

	private ConstantsService constantsService;

    public ConstantsController(ConstantsService constantsService) {
        this.constantsService = constantsService;
    }


    //  http://localhost:8080/api/constants
	@GetMapping("/constants")
	public ResponseEntity<List<Constants>> getAllConstantss() {
		System.out.print("getAllConstantss");

			return constantsService.getAllConstants();
	}

	//  http://localhost:8080/api/constants/1
	@GetMapping("/constants/{id}")
	public ResponseEntity<Constants> getConstantsById(@PathVariable("id") Integer id) {
		return constantsService.getConstantsById(id);
	}


	//  http://localhost:8080/api/constants
	@PostMapping("/constants")
	public ResponseEntity<Constants> createConstants(@RequestBody Constants constants) {
		System.out.print("createConstants");

		return constantsService.createConstants(constants);
	}

	//  http://localhost:8080/api/constants/1
	@PutMapping("/constants/{id}")
	public ResponseEntity<Constants> updateConstants(@PathVariable("id") Integer id, @RequestBody Constants constants) {
		return constantsService.updateConstants(id, constants);
	}

	//  http://localhost:8080/api/constants/1
	@DeleteMapping("/constants/{id}")
	public ResponseEntity<HttpStatus> deleteConstants(@PathVariable("id") Integer id) {
		return constantsService.deleteConstants(id);
	}


}
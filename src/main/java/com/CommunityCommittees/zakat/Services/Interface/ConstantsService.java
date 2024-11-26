package com.CommunityCommittees.zakat.Services.Interface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CommunityCommittees.zakat.Entity.Constants;

import java.util.List;

public interface ConstantsService {

     ResponseEntity<List<Constants>> getAllConstants();

     ResponseEntity<Constants> getConstantsById(Integer id);

     ResponseEntity<Constants> createConstants(Constants constants);

     ResponseEntity<Constants> updateConstants(Integer id, Constants constants);

     ResponseEntity<HttpStatus> deleteConstants(Integer id);



}

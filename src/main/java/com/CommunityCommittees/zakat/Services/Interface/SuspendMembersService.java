package com.CommunityCommittees.zakat.Services.Interface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CommunityCommittees.zakat.Entity.SuspendMembers;

import java.util.List;

public interface SuspendMembersService {

     ResponseEntity<List<SuspendMembers>> getAllSuspendMembers();

     ResponseEntity<SuspendMembers> getSuspendMembersById(Integer id);

     ResponseEntity<SuspendMembers> createSuspendMembers(SuspendMembers suspendMembers);

     ResponseEntity<SuspendMembers> updateSuspendMembers(Integer id, SuspendMembers suspendMembers);

     ResponseEntity<HttpStatus> deleteSuspendMembers(Integer id);



}

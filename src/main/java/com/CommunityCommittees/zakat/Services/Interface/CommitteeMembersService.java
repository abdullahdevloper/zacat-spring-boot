package com.CommunityCommittees.zakat.Services.Interface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CommunityCommittees.zakat.Entity.CommitteeMembers;

import java.util.List;

public interface CommitteeMembersService {

     ResponseEntity<List<CommitteeMembers>> getAllCommitteeMembers();

     ResponseEntity<CommitteeMembers> getCommitteeMembersById(Integer id);

     ResponseEntity<CommitteeMembers> createCommitteeMembers(CommitteeMembers committeeMembers);

     ResponseEntity<CommitteeMembers> updateCommitteeMembers(Integer id, CommitteeMembers committeeMembers);

     ResponseEntity<HttpStatus> deleteCommitteeMembers(Integer id);



}

package com.CommunityCommittees.zakat.Services.Interface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CommunityCommittees.zakat.Entity.MemberJob;

import java.util.List;

public interface MemberJobService {

     ResponseEntity<List<MemberJob>> getAllMemberJobs();

     ResponseEntity<MemberJob> getMemberJobById(Integer id);

     ResponseEntity<MemberJob> createMemberJob(MemberJob memberJob);

     ResponseEntity<MemberJob> updateMemberJob(Integer id, MemberJob memberJob);

     ResponseEntity<HttpStatus> deleteMemberJob(Integer id);



}

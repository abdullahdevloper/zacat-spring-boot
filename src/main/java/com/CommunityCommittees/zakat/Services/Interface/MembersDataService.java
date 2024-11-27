package com.CommunityCommittees.zakat.Services.Interface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CommunityCommittees.zakat.Entity.MembersData;
import com.CommunityCommittees.zakat.dto.MembersDataDto;

import java.util.List;

public interface MembersDataService {

     ResponseEntity<List<MembersData>> getAllMembersData();

     ResponseEntity<MembersData> getMembersDataById(Integer id);

     ResponseEntity<MembersDataDto> createMembersData(MembersDataDto membersData);

     ResponseEntity<MembersData> updateMembersData(Integer id, MembersData membersData);

     ResponseEntity<HttpStatus> deleteMembersData(Integer id);



}

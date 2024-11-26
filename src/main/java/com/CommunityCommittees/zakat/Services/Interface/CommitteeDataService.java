package com.CommunityCommittees.zakat.Services.Interface;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.CommunityCommittees.zakat.Entity.CommitteeData;

import java.util.List;

public interface CommitteeDataService {

     ResponseEntity<List<CommitteeData>> getAllCommitteeData();

     ResponseEntity<CommitteeData> getCommitteeDataById(Integer id);

     ResponseEntity<CommitteeData> createCommitteeData(CommitteeData committeeData);

     ResponseEntity<CommitteeData> updateCommitteeData(Integer id, CommitteeData committeeData);

     ResponseEntity<HttpStatus> deleteCommitteeData(Integer id);



}

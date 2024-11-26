package com.CommunityCommittees.zakat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CommunityCommittees.zakat.Entity.MembersData;
import com.CommunityCommittees.zakat.Repository.MembersDataRepo;
import com.CommunityCommittees.zakat.Services.Interface.MembersDataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MembersDataServiceImpl implements MembersDataService {

    private final MembersDataRepo membersDataRepository;

    public ResponseEntity<List<MembersData>> getAllMembersData() {
        try {
            List<MembersData> membersData = new ArrayList<>();

            membersDataRepository.findAll().forEach(membersData::add);
            
            if (membersData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(membersData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<MembersData> getMembersDataById(Integer id) {
        Optional<MembersData> membersData = membersDataRepository.findById(id);

        if (membersData.isPresent()) {
            return new ResponseEntity<>(membersData.get(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<MembersData> createMembersData(MembersData membersData) {
        try {
            MembersData membersDataObj = membersDataRepository.save(membersData);
            return new ResponseEntity<>(membersDataObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<MembersData> updateMembersData(Integer id, MembersData membersData) {
        Optional<MembersData> membersDataData = membersDataRepository.findById(id);

        if (membersDataData.isPresent()) {
            MembersData membersDataObj = membersDataData.get();
            membersDataObj.setAccomm_type(membersData.getAccomm_type());
            membersDataObj.setAdd_by(membersData.getAdd_by());
            membersDataObj.setAdd_date(membersData.getAdd_date());
            membersDataObj.setBirth_place(membersData.getBirth_place());
            membersDataObj.setBirthdate(membersData.getBirthdate());
            membersDataObj.setExperience(membersData.getExperience());
            membersDataObj.setGender(membersData.getGender());
            membersDataObj.setId_date(membersData.getId_date());
            membersDataObj.setId_location(membersData.getId_location());
            membersDataObj.setId_number(membersData.getId_number());
            membersDataObj.setId_type(membersData.getId_type());
            membersDataObj.setJob_title(membersData.getJob_title());
            membersDataObj.setMember_name(membersData.getMember_name());
            membersDataObj.setMobile(membersData.getMobile());
            membersDataObj.setPerson(membersData.getPerson());
            membersDataObj.setPerson_relation(membersData.getPerson_relation());
            membersDataObj.setPhone(membersData.getPhone());
            membersDataObj.setQualification(membersData.getQualification());
            membersDataObj.setSuspendMembers(membersData.getSuspendMembers());
            membersDataObj.setWork_type(membersData.getWork_type());
            membersDataObj.setWorkplace(membersData.getWorkplace());


            return new ResponseEntity<>(membersDataRepository.save(membersDataObj), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteMembersData(Integer id) {
        try {
            membersDataRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

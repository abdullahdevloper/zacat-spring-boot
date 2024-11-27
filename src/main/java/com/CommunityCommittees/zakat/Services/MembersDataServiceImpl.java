package com.CommunityCommittees.zakat.Services;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CommunityCommittees.zakat.Entity.Constants;
import com.CommunityCommittees.zakat.Entity.MembersData;
import com.CommunityCommittees.zakat.Repository.ConstantsRepo;
import com.CommunityCommittees.zakat.Repository.MemberJobRepo;
import com.CommunityCommittees.zakat.Repository.MembersDataRepo;
import com.CommunityCommittees.zakat.Repository.UserRepo;
import com.CommunityCommittees.zakat.Services.Interface.MembersDataService;
import com.CommunityCommittees.zakat.dto.MembersDataDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MembersDataServiceImpl implements MembersDataService {

    private final MembersDataRepo membersDataRepository;
    private final ConstantsRepo constantsRepository; 
    private final UserRepo userRepository; 
    private final MemberJobRepo memberJobRepository; 

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

    public ResponseEntity<MembersDataDto> createMembersxData(MembersDataDto membersDataDto) {
        try {
            // MembersData membersDataObj = membersDataRepository.save(membersData);
            MembersData membersData = new MembersData();
            // link relations entity
            membersData.setId_type(constantsRepository.findById(membersDataDto.getId_type()).orElseThrow());
            membersData.setAccomm_type(constantsRepository.findById(membersDataDto.getAccomm_type()).orElseThrow());
            membersData.setGender(constantsRepository.findById(membersDataDto.getGender()).orElseThrow());
            membersData.setJob_title(memberJobRepository.findById(membersDataDto.getName_job()).orElseThrow());
            membersData.setPerson_relation(constantsRepository.findById(membersDataDto.getPerson_relation()).orElseThrow());
            membersData.setQualification(constantsRepository.findById(membersDataDto.getQualification()).orElseThrow());
            membersData.setSociality(constantsRepository.findById(membersDataDto.getSociality()).orElseThrow());
            membersData.setWork_type(constantsRepository.findById(membersDataDto.getWork_type()).orElseThrow());
           
            membersData.setMember_name(membersDataDto.getMember_name());
            membersData.setPhone(membersDataDto.getPhone());
            membersData.setMobile(membersDataDto.getMobile());
            membersData.setId_number(membersDataDto.getId_number());
            membersData.setId_date(membersDataDto.getId_date());
            membersData.setId_location(membersDataDto.getId_location());
            membersData.setBirth_place(membersDataDto.getBirth_place());
            membersData.setBirthdate(membersDataDto.getBirthdate());
            membersData.setWorkplace(membersDataDto.getWorkplace());
            membersData.setExperience(membersDataDto.getExperience());
            membersData.setPhoto(membersDataDto.getPhoto());
            membersData.setPerson(membersDataDto.getPerson());
            membersData.setPerson_mobile(membersDataDto.getPerson_mobile());
            membersData.setAdd_date(membersDataDto.getAdd_date());
            membersData.setAdd_by(userRepository.findById(1).orElseThrow());

            membersDataRepository.save(membersData);
            // if (membersDataDto != null) {
            //     membersDataDto.setId(membersData.getId());
            // }
            System.out.print(membersDataDto);
            return new ResponseEntity<>(membersDataDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<MembersDataDto> createMembersData(MembersDataDto membersDataDto) {
    try {
        MembersData membersData = new MembersData();

        membersData.setId_type(constantsRepository.findById(membersDataDto.getId_type()).orElseThrow());
        membersData.setAccomm_type(constantsRepository.findById(membersDataDto.getAccomm_type()).orElseThrow());
        membersData.setGender(constantsRepository.findById(membersDataDto.getGender()).orElseThrow());
        membersData.setJob_title(memberJobRepository.findById(membersDataDto.getName_job()).orElseThrow());
        membersData.setPerson_relation(constantsRepository.findById(membersDataDto.getPerson_relation()).orElseThrow());
        membersData.setQualification(constantsRepository.findById(membersDataDto.getQualification()).orElseThrow());
        membersData.setSociality(constantsRepository.findById(membersDataDto.getSociality()).orElseThrow());
        membersData.setWork_type(constantsRepository.findById(membersDataDto.getWork_type()).orElseThrow());

        BeanUtils.copyProperties(membersDataDto, membersData, "id", "id_type","accomm_type","gender","job_title","person_relation","qualification","sociality","work_type","add_by"); // Exclude ID and relational fields
       
        membersData.setAdd_by(userRepository.findById(1).orElseThrow());

        membersDataRepository.save(membersData);

        return new ResponseEntity<>(membersDataDto, HttpStatus.CREATED);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

    public MembersData createMembersDataWithConstants(MembersData membersData) {

        Constants idType = constantsRepository.findById(membersData.getId_type().getId()).orElseThrow();
        membersData.setId_type(idType);
        Constants gender = constantsRepository.findById(membersData.getGender().getId()).orElseThrow();
        membersData.setGender(gender);
        Constants personRelation = constantsRepository.findById(membersData.getPerson_relation().getId()).orElseThrow();
        membersData.setPerson_relation(personRelation);
        Constants qualification = constantsRepository.findById(membersData.getQualification().getId()).orElseThrow();
        membersData.setQualification(qualification);
        Constants sociality = constantsRepository.findById(membersData.getSociality().getId()).orElseThrow();
        membersData.setSociality(sociality);
        Constants workType = constantsRepository.findById(membersData.getWork_type().getId()).orElseThrow();
        membersData.setWork_type(workType);
        Constants accommType = constantsRepository.findById(Integer.parseInt(membersData.getAccomm_type().toString())).orElseThrow();
        membersData.setAccomm_type(accommType);

        return membersData;
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

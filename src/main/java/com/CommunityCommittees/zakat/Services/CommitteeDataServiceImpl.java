package com.CommunityCommittees.zakat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CommunityCommittees.zakat.Entity.CommitteeData;
import com.CommunityCommittees.zakat.Repository.CommitteeDataRepo;
import com.CommunityCommittees.zakat.Services.Interface.CommitteeDataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class CommitteeDataServiceImpl implements CommitteeDataService {

    private final CommitteeDataRepo committeeDataRepository;

    public ResponseEntity<List<CommitteeData>> getAllCommitteeData() {
        System.out.println("getAllCommitteeData");
        try {
            List<CommitteeData> committeeData = new ArrayList<>();

            committeeDataRepository.findAll().forEach(committeeData::add);
            
            if (committeeData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(committeeData, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CommitteeData> getCommitteeDataById(Integer id) {
        Optional<CommitteeData> constantData = committeeDataRepository.findById(id);

        if (constantData.isPresent()) {
            return new ResponseEntity<>(constantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<CommitteeData> createCommitteeData(CommitteeData committeeData) {
        try {
        System.out.println("createCommitteeData");

            CommitteeData committeeDataObj = committeeDataRepository.save(committeeData);
            return new ResponseEntity<>(committeeDataObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CommitteeData> updateCommitteeData(Integer id, CommitteeData committeeData) {
        Optional<CommitteeData> _committeeData = committeeDataRepository.findById(id);

        if (_committeeData.isPresent()) {
            CommitteeData committeeDataObj = _committeeData.get();
            committeeDataObj.setAdd_by(committeeData.getAdd_by());
            committeeDataObj.setAdd_date(committeeData.getAdd_date());
            committeeDataObj.setCommitteeMembers(committeeData.getCommitteeMembers());
            committeeDataObj.setCommittee_type_id(committeeData.getCommittee_type_id());
            committeeDataObj.setList_id(committeeData.getList_id());
            committeeDataObj.setPartner_id(committeeData.getPartner_id());
            committeeDataObj.setStatus(committeeData.getStatus());
            

            return new ResponseEntity<>(committeeDataRepository.save(committeeDataObj), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteCommitteeData(Integer id) {
        try {
            committeeDataRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

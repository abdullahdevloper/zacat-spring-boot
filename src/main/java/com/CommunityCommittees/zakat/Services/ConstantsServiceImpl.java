package com.CommunityCommittees.zakat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CommunityCommittees.zakat.Entity.Constants;
import com.CommunityCommittees.zakat.Repository.ConstantsRepo;
import com.CommunityCommittees.zakat.Services.Interface.ConstantsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class ConstantsServiceImpl implements ConstantsService {

    private final ConstantsRepo constantsRepository;

    public ResponseEntity<List<Constants>> getAllConstants() {
        try {
            List<Constants> constants = new ArrayList<>();

            constantsRepository.findAll().forEach(constants::add);
            
            if (constants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(constants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Constants> getConstantsById(Integer id) {
        Optional<Constants> constantData = constantsRepository.findById(id);

        if (constantData.isPresent()) {
            return new ResponseEntity<>(constantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Constants> createConstants(Constants constant) {
        try {
            Constants constantObj = constantsRepository.save(constant);
            return new ResponseEntity<>(constantObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Constants> updateConstants(Integer id, Constants constant) {
        Optional<Constants> constantData = constantsRepository.findById(id);

        if (constantData.isPresent()) {
            Constants constanObj = constantData.get();
            constanObj.setAccomm_type(constant.getAccomm_type());
            constanObj.setAdd_date(constant.getAdd_date());
            constanObj.setCode_constants(constant.getCode_constants());
            constanObj.setCommittee_type(constant.getCommittee_type());
            constanObj.setGender(constant.getGender());
            constanObj.setId_type(constant.getId_type());
            // constanObj.setJob_title(constant.getJob_title());
            constanObj.setName_constants(constant.getName_constants());
            constanObj.setPerson_relation(constant.getPerson_relation());
            constanObj.setPositionType(constant.getPositionType());
            constanObj.setQualification(constant.getQualification());
            constanObj.setSociality(constant.getSociality());
            constanObj.setStatus(constant.getStatus());
            constanObj.setWork_type(constant.getWork_type());
            constanObj.setUser(constant.getUser());

            return new ResponseEntity<>(constantsRepository.save(constanObj), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteConstants(Integer id) {
        try {
            constantsRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

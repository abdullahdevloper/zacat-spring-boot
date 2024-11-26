package com.CommunityCommittees.zakat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CommunityCommittees.zakat.Entity.SuspendMembers;
import com.CommunityCommittees.zakat.Repository.SuspendMembersRepo;
import com.CommunityCommittees.zakat.Services.Interface.SuspendMembersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class SuspendMembersServicImpl implements SuspendMembersService {

    private final SuspendMembersRepo suspendMembersRepository;

    public ResponseEntity<List<SuspendMembers>> getAllSuspendMembers() {
        try {
            List<SuspendMembers> suspendMembers = new ArrayList<>();

            suspendMembersRepository.findAll().forEach(suspendMembers::add);
            
            if (suspendMembers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(suspendMembers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<SuspendMembers> getSuspendMembersById(Integer id) {
        Optional<SuspendMembers> SuspendMembersData = suspendMembersRepository.findById(id);

        if (SuspendMembersData.isPresent()) {
            return new ResponseEntity<>(SuspendMembersData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<SuspendMembers> createSuspendMembers(SuspendMembers suspendMembers) {
        try {
            SuspendMembers suspendMembersObj = suspendMembersRepository.save(suspendMembers);
            return new ResponseEntity<>(suspendMembersObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<SuspendMembers> updateSuspendMembers(Integer id, SuspendMembers suspendMembers) {
        Optional<SuspendMembers> suspendMembersData = suspendMembersRepository.findById(id);

        if (suspendMembersData.isPresent()) {
            SuspendMembers suspendMembersObj = suspendMembersData.get();
            suspendMembersObj.setAdd_by(suspendMembers.getAdd_by());
            suspendMembersObj.setAdd_date(suspendMembers.getAdd_date());
            suspendMembersObj.setMembersData(suspendMembers.getMembersData());
            suspendMembersObj.setSuspend_date(suspendMembers.getSuspend_date());
            suspendMembersObj.setSuspend_reason(suspendMembers.getSuspend_reason());
            suspendMembersObj.setSuspend_type(suspendMembers.getSuspend_type());
            
            return new ResponseEntity<>(suspendMembersRepository.save(suspendMembersObj), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteSuspendMembers(Integer id) {
        try {
            suspendMembersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

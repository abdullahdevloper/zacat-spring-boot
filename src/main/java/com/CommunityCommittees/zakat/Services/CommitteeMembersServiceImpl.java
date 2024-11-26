package com.CommunityCommittees.zakat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CommunityCommittees.zakat.Entity.CommitteeMembers;
import com.CommunityCommittees.zakat.Repository.CommitteeMembersRepo;
import com.CommunityCommittees.zakat.Services.Interface.CommitteeMembersService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class CommitteeMembersServiceImpl implements CommitteeMembersService {

    private final CommitteeMembersRepo committeeMembersRepository;

    public ResponseEntity<List<CommitteeMembers>> getAllCommitteeMembers() {
        try {
            List<CommitteeMembers> committeeMembers = new ArrayList<>();

            committeeMembersRepository.findAll().forEach(committeeMembers::add);
            
            if (committeeMembers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(committeeMembers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CommitteeMembers> getCommitteeMembersById(Integer id) {
        Optional<CommitteeMembers> constantData = committeeMembersRepository.findById(id);

        if (constantData.isPresent()) {
            return new ResponseEntity<>(constantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<CommitteeMembers> createCommitteeMembers(CommitteeMembers committeeMembers) {
        try {
            CommitteeMembers committeeMembersObj = committeeMembersRepository.save(committeeMembers);
            return new ResponseEntity<>(committeeMembersObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<CommitteeMembers> updateCommitteeMembers(Integer id, CommitteeMembers committeeMembers) {
        Optional<CommitteeMembers> committeeMembersData = committeeMembersRepository.findById(id);

        if (committeeMembersData.isPresent()) {
            CommitteeMembers committeeMembersObj = committeeMembersData.get();
            committeeMembersObj.setUser(committeeMembers.getUser());
            committeeMembersObj.setAdd_date(committeeMembers.getAdd_date());
            committeeMembersObj.setCommitteeData(committeeMembers.getCommitteeData());
            committeeMembersObj.setMemberJob(committeeMembers.getMemberJob());
            committeeMembersObj.setMember_id(committeeMembers.getMember_id());
            committeeMembersObj.setMembersData(committeeMembers.getMembersData());
            committeeMembersObj.setPositionType(committeeMembers.getPositionType());
            

            return new ResponseEntity<>(committeeMembersRepository.save(committeeMembersObj), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteCommitteeMembers(Integer id) {
        try {
            committeeMembersRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

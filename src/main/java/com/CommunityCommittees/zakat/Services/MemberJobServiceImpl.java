package com.CommunityCommittees.zakat.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CommunityCommittees.zakat.Entity.MemberJob;
import com.CommunityCommittees.zakat.Repository.MemberJobRepo;
import com.CommunityCommittees.zakat.Services.Interface.MemberJobService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberJobServiceImpl implements MemberJobService {

    private final MemberJobRepo memberJobRepository;

    public ResponseEntity<List<MemberJob>> getAllMemberJobs() {
        try {

            List<MemberJob> memberJob = new ArrayList<>();

            memberJobRepository.findAll().forEach(memberJob::add);
            
            if (memberJob.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.print("getAllMemberJobs");
            System.out.print(memberJob);

            return new ResponseEntity<>(memberJob, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<MemberJob> getMemberJobById(Integer id) {
        Optional<MemberJob> constantData = memberJobRepository.findById(id);

        if (constantData.isPresent()) {
            return new ResponseEntity<>(constantData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<MemberJob> createMemberJob(MemberJob memberJob) {
        try {
            System.out.print("memberJob");
            System.out.print(memberJob);
            MemberJob memberJobObj = memberJobRepository.save(memberJob);
            return new ResponseEntity<>(memberJobObj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<MemberJob> updateMemberJob(Integer id, MemberJob memberJob) {
        Optional<MemberJob> memberJobData = memberJobRepository.findById(id);

        if (memberJobData.isPresent()) {
            MemberJob memberJobObj = memberJobData.get();
            memberJobObj.setAdd_by(memberJob.getAdd_by());
            memberJobObj.setAdd_date(memberJob.getAdd_date());
            memberJobObj.setCommitteeMembers(memberJob.getCommitteeMembers());
            memberJobObj.setName_job(memberJob.getName_job());
            memberJobObj.setStatus(memberJob.getStatus());
            

            return new ResponseEntity<>(memberJobRepository.save(memberJobObj), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteMemberJob(Integer id) {
        try {
            memberJobRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

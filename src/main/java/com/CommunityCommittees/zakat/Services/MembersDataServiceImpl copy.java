// ... other imports
import com.CommunityCommittees.zakat.Repository.ConstantsRepo;

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

@Service
public class MembersDataServiceImpl implements MembersDataService {
    // ... other code

    private final ConstantsRepo constantsRepository; // Inject ConstantsRepo

    // ... (Inside createMembersData)
    public ResponseEntity<MembersData> createMembersData(MembersData membersData) {
        try {
            MembersData membersDataObj = membersDataRepository.save(createMembersDataWithConstants(membersData)); // Modify to save the properly formed entity.
            return new ResponseEntity<>(membersDataObj, HttpStatus.CREATED);
        } catch (Exception e) {
             return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public MembersData createMembersDataWithConstants(MembersData membersData) {

            Constants idType = constantsRepository.findById(Integer.parseInt(membersData.getId_type().toString())).orElseThrow();
            membersData.setId_type(idType);
            Constants gender = constantsRepository.findById(Integer.parseInt(membersData.getGender().toString())).orElseThrow();
            membersData.setGender(gender);
            Constants jobTitle = constantsRepository.findById(Integer.parseInt(membersData.getJob_title().toString())).orElseThrow();
            membersData.setJob_title(jobTitle);
            Constants personRelation = constantsRepository.findById(Integer.parseInt(membersData.getPerson_relation().toString())).orElseThrow();
            membersData.setPerson_relation(personRelation);
            Constants qualification = constantsRepository.findById(Integer.parseInt(membersData.getQualification().toString())).orElseThrow();
            membersData.setQualification(qualification);
            Constants sociality = constantsRepository.findById(Integer.parseInt(membersData.getSociality().toString())).orElseThrow();
            membersData.setSociality(sociality);
            Constants workType = constantsRepository.findById(Integer.parseInt(membersData.getWork_type().toString())).orElseThrow();
            membersData.setWork_type(workType);
            Constants accommType = constantsRepository.findById(Integer.parseInt(membersData.getAccomm_type().toString())).orElseThrow();
            membersData.setAccomm_type(accommType);

            return membersData;
    }
    public ResponseEntity<MembersData> updateMembersData(Integer id, MembersData membersData) {
        //.. other code


        if (membersDataData.isPresent()) {
          MembersData membersDataObj = createMembersDataWithConstants(membersData); // Modify to save the properly formed entity.
            return new ResponseEntity<>(membersDataRepository.save(membersDataObj), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

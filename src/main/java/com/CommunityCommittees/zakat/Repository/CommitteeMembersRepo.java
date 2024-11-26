package com.CommunityCommittees.zakat.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.CommunityCommittees.zakat.Entity.CommitteeMembers;

public interface CommitteeMembersRepo extends /*CrudRepository<User, Integer>,*/JpaRepository<CommitteeMembers, Integer>  {

}

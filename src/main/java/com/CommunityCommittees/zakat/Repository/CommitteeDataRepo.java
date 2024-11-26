package com.CommunityCommittees.zakat.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.CommunityCommittees.zakat.Entity.CommitteeData;

public interface CommitteeDataRepo extends /*CrudRepository<User, Integer>,*/JpaRepository<CommitteeData, Integer>  {

}

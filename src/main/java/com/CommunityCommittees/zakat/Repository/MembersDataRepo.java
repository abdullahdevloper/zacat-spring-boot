package com.CommunityCommittees.zakat.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.CommunityCommittees.zakat.Entity.MembersData;

public interface MembersDataRepo extends /*CrudRepository<User, Integer>,*/JpaRepository<MembersData, Integer>  {

}

package com.CommunityCommittees.zakat.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.CommunityCommittees.zakat.Entity.SuspendMembers;

public interface SuspendMembersRepo extends /*CrudRepository<User, Integer>,*/JpaRepository<SuspendMembers, Integer>  {

}

package com.CommunityCommittees.zakat.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.CommunityCommittees.zakat.Entity.Constants;

public interface ConstantsRepo extends /*CrudRepository<User, Integer>,*/JpaRepository<Constants, Integer>  {

}

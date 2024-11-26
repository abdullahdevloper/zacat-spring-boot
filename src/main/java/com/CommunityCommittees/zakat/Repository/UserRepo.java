package com.CommunityCommittees.zakat.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.CommunityCommittees.zakat.Entity.User;

public interface UserRepo extends /*CrudRepository<User, Integer>,*/JpaRepository<User, Integer>  {

}

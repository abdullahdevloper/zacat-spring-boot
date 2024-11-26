package com.CommunityCommittees.zakat.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CommunityCommittees.zakat.Entity.MemberJob;

public interface MemberJobRepo extends /*CrudRepository<User, Integer>,*/JpaRepository<MemberJob, Integer>  {

}

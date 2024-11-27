package com.CommunityCommittees.zakat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MembersDataDto {

     private Integer id;
    private String member_name;
    private BigInteger phone;
    private BigInteger mobile;

    private BigInteger id_number;
    private Date id_date;

    private String id_location;
    private String birth_place;
    private Date birthdate;

    private String workplace;

    private String experience;
    private String photo;
    private String person;
    private BigInteger person_mobile;
    private LocalDateTime add_date;
    private Integer id_type;
    private Integer gender;
    private Integer name_job;
    private Integer person_relation;
    private Integer qualification;
    private Integer sociality;
    private Integer work_type;
    private Integer accomm_type;
    private Integer add_by;

}

package com.CommunityCommittees.zakat.Entity;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An entity class represents a table in a relational database
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "MembersData")
public class MembersData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Constants id_type;
    // private Integer id_type;

    @ManyToOne
    @JoinColumn(name = "gender")
    private Constants gender;
    // private Integer gender;

    @ManyToOne
    @JoinColumn(name = "job_title")
    private MemberJob job_title;

    @ManyToOne
    @JoinColumn(name = "person_relation")
    private Constants person_relation;
    // private Integer person_relation;

    @ManyToOne
    @JoinColumn(name = "qualification")
    private Constants qualification;
    // private Integer qualification;

    @ManyToOne
    @JoinColumn(name = "sociality")
    private Constants sociality;
    // private Integer sociality;

    @ManyToOne
    @JoinColumn(name = "work_type")
    private Constants work_type;
    // private Integer work_type;

    @ManyToOne
    @JoinColumn(name = "accomm_type")
    private Constants accomm_type;
    // private Integer accomm_type;

    @ManyToOne
    @JoinColumn(name = "add_by")
    private User add_by;
    // private Integer add_by;

    @OneToOne(mappedBy = "membersData", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore  // Add this to ignore the suspendMembers field during serialization
    private SuspendMembers suspendMembers;
}

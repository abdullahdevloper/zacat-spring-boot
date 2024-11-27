package com.CommunityCommittees.zakat.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "MemberJob")
public class MemberJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer status = 1;
    private String name_job;
    private LocalDateTime add_date = LocalDateTime.now();

    // Relations
    @ManyToOne
    @JoinColumn(name = "add_by")
    private User add_by;
    // private Integer add_by;

    
    @OneToMany(mappedBy = "job_title")
    @JsonIgnore
    private Set<MembersData> membersData = new HashSet<>();


    @OneToMany(mappedBy = "memberJob")
    private Set<CommitteeMembers> committeeMembers = new HashSet<>();
}

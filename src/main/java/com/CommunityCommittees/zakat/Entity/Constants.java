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
@Table(name = "Constants")
public class Constants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name_constants;
    private String code_constants;
    private Integer status=1;
    private LocalDateTime add_date=LocalDateTime.now();

    // Relations
    @ManyToOne
    @JoinColumn(name = "add_by")
    private User user;

    @OneToMany(mappedBy = "id_type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore

    private List<MembersData> id_type ;

    @OneToMany(mappedBy = "gender", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MembersData> gender ;

   
    @OneToMany(mappedBy = "person_relation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MembersData> person_relation ;

    @OneToMany(mappedBy = "qualification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MembersData> qualification ;

    @OneToMany(mappedBy = "sociality", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MembersData> sociality ;

    @OneToMany(mappedBy = "accomm_type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MembersData> accomm_type ;

    
    @OneToMany(mappedBy = "work_type", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<MembersData> work_type ;

    
    @OneToMany(mappedBy = "committee_type_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<CommitteeData> committee_type = new HashSet<>();

        
    @OneToMany(mappedBy = "positionType", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore

    private Set<CommitteeMembers> positionType = new HashSet<>();

}

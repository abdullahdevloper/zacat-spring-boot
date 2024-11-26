package com.CommunityCommittees.zakat.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String user_name;
    private String full_name;
    private Integer status;
    private String add_by;
    private String password;
    private LocalDateTime add_date;

    @OneToMany(mappedBy = "add_by")
    private Set<MembersData> membersData = new HashSet<>();


    @OneToMany(mappedBy = "add_by")
    private Set<MemberJob> membersJob = new HashSet<>();

    @OneToMany(mappedBy = "add_by")
    private Set<CommitteeData> committeeData = new HashSet<>();

    @OneToMany(mappedBy = "add_by")
    private Set<SuspendMembers> suspendMembers = new HashSet<>();
}

package com.CommunityCommittees.zakat.Entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
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
    private String job_title;
    private Integer status=1;
    private LocalDateTime add_date=LocalDateTime.now();

    // Relations
    @ManyToOne
    @JoinColumn(name = "add_by")
    private User add_by;
    // private Integer add_by;


    @OneToMany(mappedBy = "memberJob")
    private Set<CommitteeMembers> committeeMembers = new HashSet<>();
}

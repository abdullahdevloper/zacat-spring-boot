package com.CommunityCommittees.zakat.Entity;

import java.time.LocalDateTime;
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
@Table(name = "CommitteeMembers")
public class CommitteeMembers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer member_id;

    private LocalDateTime add_date;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MembersData membersData;

    @ManyToOne
    @JoinColumn(name = "committee_id")
    private CommitteeData committeeData;
    // protected Integer committee_id;

    @ManyToOne
    @JoinColumn(name = "job_title")
    private MemberJob memberJob;
    // private Integer job_title;

    @ManyToOne
    @JoinColumn(name = "position")
    private Constants positionType;
    // private Integer position;

    @ManyToOne
    @JoinColumn(name = "add_by")
    private User user;
}

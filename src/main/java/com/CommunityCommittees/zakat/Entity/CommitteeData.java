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
@Table(name = "CommitteeData")
public class CommitteeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    private Integer partner_id;
    private Integer list_id;
    private Integer status;
    private LocalDateTime add_date;

    @ManyToOne
    @JoinColumn(name = "committee_type_id")
    private Constants committee_type_id;
    // private Integer committee_type_id;

    @ManyToOne
    @JoinColumn(name = "add_by")
    private User add_by;
    // private Integer add_by;

    @OneToMany(mappedBy = "committeeData")
    private Set<CommitteeMembers> committeeMembers = new HashSet<>();
}

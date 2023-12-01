package com.aptiv.dataAnalytics.domaine;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "crew")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id")
    private Family familyDetails;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_leader_Id")
    private TeamLeader teamLeaderDetails;
}

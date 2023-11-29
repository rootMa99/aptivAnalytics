package com.aptiv.dataAnalytics.domaine;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "teamLeader")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TeamLeader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamLeaderDetails")
    @JsonIgnore
    private List<Crew> crews;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_leader_id")
    private ShiftLeader shiftLeaderDetails;
}

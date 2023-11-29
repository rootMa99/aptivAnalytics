package com.aptiv.dataAnalytics.domaine;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name="family")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Familly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project projectDetails;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "familyDetails")
    @JsonIgnore
    private List<Crew> crews;
}

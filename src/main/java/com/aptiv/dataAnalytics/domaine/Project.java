package com.aptiv.dataAnalytics.domaine;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "project")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Data> data;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectDetails")
    @JsonIgnore
    private List<Familly> familly;
}

package com.aptiv.dataAnalytics.domaine;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name ="coordinator")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coordinatorDetails")
    @JsonIgnore
    private List<ShiftLeader> shiftLeaders;
}

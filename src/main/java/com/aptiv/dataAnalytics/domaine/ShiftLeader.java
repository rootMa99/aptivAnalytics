package com.aptiv.dataAnalytics.domaine;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "shift_leader")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ShiftLeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
}

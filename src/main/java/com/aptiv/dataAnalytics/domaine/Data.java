package com.aptiv.dataAnalytics.domaine;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity(name="data")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "plant", nullable = false)
    private String plant;
    @Column(name = "area")
    private String area;
    @Column(name = "month")
    private String month;
    @Column(name = "week")
    private String week;
    @Column(name = "date")
    private Date date;
    @Column(name = "filter")
    private Boolean filter;

}

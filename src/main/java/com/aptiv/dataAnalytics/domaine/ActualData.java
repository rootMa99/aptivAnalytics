package com.aptiv.dataAnalytics.domaine;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "actual_data")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ActualData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "output")
    private Integer output;
    @Column(name = "prodh")
    private Integer prodH;
    @Column(name="paidh")
    private Double paidH;
    @Column(name = "totalhc")
    private Double totalhc;
    @Column(name = "hc")
    private Double hc;
    @Column(name = "ot")
    private Double ot;
    @Column(name = "ab")
    private Double ab;
    @Column(name = "tlo")
    private Double tlo;
    @Column(name = "dt")
    private Double dt;
    @OneToOne(mappedBy = "actual_data")
    private Data data;
}

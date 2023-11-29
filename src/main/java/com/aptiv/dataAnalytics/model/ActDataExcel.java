package com.aptiv.dataAnalytics.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ActDataExcel {
    private int output;
    private double prodh;
    private double paidh;
    private double toatlHc;
    private double hc;
    private double ot;
    private double ab;
    private double tlo;
    private double dt;

}

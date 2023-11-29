package com.aptiv.dataAnalytics.model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DataFromExcel {

    private String plant;
    private String area;
    private String project;
    private String family;
    private String crew;
    private String teamLeader;
    private String shiftLeader;
    private String coordinator;
    private String month;
    private String week;
    private Date date;
    private Boolean filter;

    private ActDataExcel actDataExcel;
    private DataTargetExcel dataTargetExcel;
}

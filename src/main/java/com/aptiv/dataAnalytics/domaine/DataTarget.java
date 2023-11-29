package com.aptiv.dataAnalytics.domaine;

import jakarta.persistence.Id;

public class DataTarget {
    @Id
    private Long id;
    private Double prodTarget;
    private Double payedTarget;
    private Double hcTarget;
    private Double absTarget;
    private Double dtTarget;
    private Double scrap;
    private Double scrapTarget;
}
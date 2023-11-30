package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.ActualData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActualDataRepo extends JpaRepository<ActualData, Long> {
}

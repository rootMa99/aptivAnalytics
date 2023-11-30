package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.DataTarget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataTargetRepo extends JpaRepository<DataTarget, Long> {
}

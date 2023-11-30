package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.Data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepo extends JpaRepository<Data, Long> {
}

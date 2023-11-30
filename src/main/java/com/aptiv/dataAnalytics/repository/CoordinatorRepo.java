package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.Coordinator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordinatorRepo extends JpaRepository<Coordinator, Long> {
    Coordinator findCoordinatorByName(String name);
}

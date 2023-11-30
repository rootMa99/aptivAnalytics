package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.Crew;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewRepo extends JpaRepository<Crew, Long> {
    Crew findCrewByName(String name);
}

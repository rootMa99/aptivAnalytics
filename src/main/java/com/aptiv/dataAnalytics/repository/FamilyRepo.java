package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.Family;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepo extends JpaRepository<Family, Long> {
    Family findFamillyByName(String name);
}

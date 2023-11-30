package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.Familly;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepo extends JpaRepository<Familly, Long> {
    Familly findFamillyByName(String name);
}

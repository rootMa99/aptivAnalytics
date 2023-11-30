package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.ShiftLeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftLeaderRepo extends JpaRepository<ShiftLeader, Long> {
    ShiftLeader findShiftLeaderByName(String name);
}

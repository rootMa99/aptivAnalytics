package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.TeamLeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamLeaderRepo extends JpaRepository<TeamLeader, Long> {
    TeamLeader findTeamLeaderByName(String name);
}

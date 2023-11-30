package com.aptiv.dataAnalytics.repository;

import com.aptiv.dataAnalytics.domaine.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {

    Project findProjectByName(String name);
}

package com.MAJORPROJECT.LOVABLE.repository;

import com.MAJORPROJECT.LOVABLE.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}


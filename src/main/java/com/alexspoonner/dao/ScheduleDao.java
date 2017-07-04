package com.alexspoonner.dao;

import com.alexspoonner.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Schedule Repo
 */
@Repository
@Transactional
public interface ScheduleDao extends JpaRepository<Schedule, Long> {
}

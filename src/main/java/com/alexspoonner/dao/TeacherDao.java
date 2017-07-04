package com.alexspoonner.dao;

import com.alexspoonner.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Teacher Repo
 */
@Repository
@Transactional
public interface TeacherDao extends JpaRepository<Teacher, Long> {
}

package com.alexspoonner.dao;

import com.alexspoonner.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Student Repo
 */
@Repository
@Transactional
public interface StudentDao extends JpaRepository<Student, Long> {
}

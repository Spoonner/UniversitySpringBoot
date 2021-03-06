package com.alexspoonner.dao;

import com.alexspoonner.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Subject Repo
 */
@Repository
@Transactional
public interface SubjectDao extends JpaRepository<Subject, Long> {
    List<Subject> findAllByOrderByName();
}

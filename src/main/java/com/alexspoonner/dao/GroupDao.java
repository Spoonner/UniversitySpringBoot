package com.alexspoonner.dao;

import com.alexspoonner.model.AcademicGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * AcademicGroup Repo
 */
@Repository
@Transactional
public interface GroupDao extends JpaRepository<AcademicGroup, Long> {
    List<AcademicGroup> findAllByOrderByCourseNumber();
}

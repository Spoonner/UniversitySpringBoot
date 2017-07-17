package com.alexspoonner.dao;

import com.alexspoonner.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Mark Repo
 */
@Repository
@Transactional
public interface MarkDao extends JpaRepository<Mark, Long> {
    List<Mark> findALlByOrderByDateDesc();
    List<Mark> findAllByStudent_StudentId(Long studenId);
}

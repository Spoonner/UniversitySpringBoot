package com.alexspoonner.dao;

import com.alexspoonner.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Student Repo
 */
@Repository
@Transactional
public interface StudentDao extends JpaRepository<Student, Long> {
    List<Student> findTop10ByOrderByAverageMarkDesc();
    Student findStudentByEmailAndPassword(String email, String password);
    List<Student> findAllByOrdOrderByLastName();
}

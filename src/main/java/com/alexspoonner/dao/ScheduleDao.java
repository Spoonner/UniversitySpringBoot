package com.alexspoonner.dao;

import com.alexspoonner.model.AcademicGroup;
import com.alexspoonner.model.Schedule;
import com.alexspoonner.model.Subject;
import com.alexspoonner.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Schedule Repo
 */
@Repository
@Transactional
public interface ScheduleDao extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByOrderByDateDesc();

    List<Schedule> findAllByAcademicGroup_GroupId(Long groupId);

    @Query("select s.teacher from Schedule s where s.academicGroup.groupId = :#{academicGroup.groupId}")
    List<Teacher> findAllTeachersByGroupId(@Param("academicGroup") AcademicGroup group);

    @Query("select distinct s.subject from Schedule s where s.teacher.teacherId = :#{teacher.teacherId}")
    List<Subject> findAllSubjectsByTeacherId(@Param("teacher") Teacher teacher);
}
